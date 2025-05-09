package akka.bank.app

import akka.actor.typed.SpawnProtocol.Spawn
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior, Props, Scheduler, SpawnProtocol}
import akka.actor.typed.scaladsl.AskPattern.Askable
import akka.bank.actor.BankAccountActor
import akka.bank.model.{BankAccountMessage, Deposit, GetBalance, Withdraw}
import akka.util.Timeout

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt

object MainV2 extends App {

  def behavior(balance: Int): Behavior[BankAccountMessage] = Behaviors.receiveMessage {
    case Deposit(amount)  => behavior(balance + amount)
    case Withdraw(amount) => behavior(balance - amount)
    case GetBalance(replyTo) =>
      replyTo ! balance
      Behaviors.same
  }

  val actorSystem = ActorSystem(SpawnProtocol(), name = "MyBankActorSystem")

  implicit val timeout: Timeout     = Timeout(2.seconds)
  implicit val scheduler: Scheduler = actorSystem.scheduler
  import actorSystem.executionContext

  private val bankAccountFuture: Future[ActorRef[BankAccountMessage]] =
    actorSystem.ask[ActorRef[BankAccountMessage]] { ref =>
      Spawn[BankAccountMessage](
        behavior = BankAccountActor().behavior(balance = 0),
        name = "account1",
        props = Props.empty,
        replyTo = ref
      )
    }

  private val future = for {
    bankAccount <- bankAccountFuture
    balance1    <- bankAccount ? GetBalance.apply(_)
    _           = println(balance1)
    _           = bankAccount ! Deposit(200)
    _           = bankAccount ! Withdraw(50)
    balance2    <- bankAccount ? GetBalance
    _           = println(balance2)
  } yield ()

  Await.result(future, 2.seconds)

  actorSystem.terminate()
}

package akka.bank.actor

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.bank.model.{BankAccountMessage, Deposit, GetBalance, PrintBalance, Withdraw}

class BankAccountActor {


  def behavior(balance: Int): Behavior[BankAccountMessage] = Behaviors.receiveMessage {
    case Deposit(amount) => behavior(balance + amount)
    case Withdraw(amount) => behavior(balance - amount)
    case GetBalance(replyTo) =>
      replyTo ! balance
      Behaviors.same
    case PrintBalance =>
      println(s"balance = $balance")
      behavior(balance)
  }
}

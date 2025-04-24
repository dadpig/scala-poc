package akka.bank.actor

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.bank.model.{BankAccountMessage, Deposit, PrintBalance, Withdraw}

class BankAccountActor {


  def behavior(balance: Int): Behavior[BankAccountMessage] = Behaviors.receiveMessage {
    case Deposit(amount) => behavior(balance + amount)
    case Withdraw(amount) => behavior(balance - amount)
    case PrintBalance =>
      println(s"balance = $balance")
      behavior(balance)
  }
}

package akka.bank.model

//case class are immutable used to hold or carry data to functions
case class Withdraw(amount: Int) extends BankAccountMessage

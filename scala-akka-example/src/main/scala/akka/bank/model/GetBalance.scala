package akka.bank.model

import akka.actor.typed.ActorRef

case class GetBalance(replayTo:ActorRef[Int]) extends BankAccountMessage{
  def apply(replayTo: ActorRef[Int]): GetBalance = new GetBalance(replayTo)
}

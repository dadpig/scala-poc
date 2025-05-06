package ticket.system.model

class EventSystem {

  private var shows: List[Show] = List()

  def addShow(show: Show): Unit = {
    shows = shows :+ show
  }

  def sellTicket(show: Show, zone: String, seatNumber: Int): Either[String, Ticket] = {
    shows.find(_.name == show.getName) match {
      case Some(show) =>
        show.event.sellTicket(zone, seatNumber).map(ticket => ticket.copy(show = show))
      case None =>
        Left(s"Show $show.getName not found.")
    }
  }
}
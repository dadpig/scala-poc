package ticket.system.model

class Event (val name: String, val zones: Map[String, Int]) {
  private var soldTickets: Map[String, Set[Int]] = zones.map(zone => zone._1 -> Set.empty[Int])

  def getSoldTickets: Map[String, Set[Int]] = soldTickets

  def getAvailableSeats(zone: String): Int = zones(zone) - soldTickets(zone).size

  def getName: String = name

  def sellTicket(zone: String, seatNumber: Int): Either[String, Ticket] = {
    if (!zones.contains(zone)) {
      Left(s"Zone $zone does not exist.")
    } else if (soldTickets(zone).contains(seatNumber)) {
      Left(s"Seat $seatNumber in zone $zone is already sold.")
    } else if (soldTickets(zone).size >= zones(zone)) {
      Left(s"Zone $zone is at full capacity.")
    } else {
      soldTickets = soldTickets.updated(zone, soldTickets(zone) + seatNumber)
      Right(Ticket(show = null, seatNumber = seatNumber, zone = zone)) // Show will be set later
    }
  }

  override def toString: String = {
    s"Event: $name, Zones: $zones"
  }

}

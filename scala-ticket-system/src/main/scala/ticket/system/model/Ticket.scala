package ticket.system.model

case class Ticket(show: Show, seatNumber: Int, zone: String) {
  
  def getShow: Show = show
  def getSeatNumber: Int = seatNumber
  def getZone: String = zone
}

package ticket.system.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import ticket.system.model.{Show, Ticket, Event}

class EventSystemSpec extends AnyFlatSpec with Matchers {

  var event = new Event("Sepultura - Life Through Death", Map("A" -> 100, "B" -> 50))
  var show = Show("Concert", "2026-05-31", event)

  "A TicketSystem" should "add a show and sell a ticket" in {

    val ticketSystem = new EventSystem
    ticketSystem.addShow(show)
    val result = ticketSystem.sellTicket(show, "A", 1)

    result shouldBe a[Right[_, _]]
    result.right.get.show shouldBe show
    result.right.get.seatNumber shouldBe 1
    result.right.get.zone shouldBe "A"
    //seat number 1 in zone A is sold
    result.right.get.show.event.getSoldTickets("A") should contain(1)
    //show the available seats in zone A 99
    result.right.get.show.event.getAvailableSeats("A") shouldBe 99
    //show the available seats in zone B 50
    result.right.get.show.event.getAvailableSeats("B") shouldBe 50
  }

  it should "not sell a ticket for a non-existent show" in {
    val ticketSystem = new EventSystem

    val result = ticketSystem.sellTicket(show.copy(name = "Non Existent Show", date = null, event=null), "A", 1)

    result shouldBe a[Left[_, _]]
    result.left.get shouldBe "Show Name: Non Existent Show, Date: null, Event: null.getName not found."
  }

  it should "not sell a ticket for a non-existent zone" in {

    val ticketSystem = new EventSystem

    ticketSystem.addShow(show)
    val result = ticketSystem.sellTicket(show, "C", 1)

    result shouldBe a[Left[_, _]]
    result.left.get shouldBe "Zone C does not exist."
  }

  it should "not sell a ticket for an already sold seat" in {

    val ticketSystem = new EventSystem

    ticketSystem.addShow(show)
    ticketSystem.sellTicket(show, "A", 1)
    val result = ticketSystem.sellTicket(show, "A", 1)

    result shouldBe a[Left[_, _]]
    result.left.get shouldBe "Seat 1 in zone A is already sold."
  }

  it should "not sell a ticket if the zone is at full capacity" in {
    val eventCopy = new Event("Sepultura - Life Through Death", Map("A" -> 1, "B" -> 50))
    val showCopy = show.copy(event = eventCopy)
    val ticketSystem = new EventSystem

    ticketSystem.addShow(showCopy)
    ticketSystem.sellTicket(showCopy, "A", 1)
    val result = ticketSystem.sellTicket(showCopy, "A", 2)

    result shouldBe a[Left[_, _]]
    result.left.get shouldBe "Zone A is at full capacity."
  }
}
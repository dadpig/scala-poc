package ticket.system.model

case class Show(name: String, date: String, event: Event) {
  
  def getName: String = name

  override def toString: String ={
    s"Name: $name, Date: $date, Event: $event"
  }
}

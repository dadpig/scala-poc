package grocery.domain

case class Grocery() {
  var items: List[Task] = List()

  def addItem(item: Task): Unit = {
    items = items :+ item
  }

  def removeItem(item: Task): Unit = {
    items = items.filterNot(_ == item)
  }

  def markAsDone(item: Task): Unit = {
    items = items.map(i => if (i == item) i.copy(status = "done") else i)
  }

  def markAsNotDone(item: Task): Unit = {
    items = items.map(i => if (i == item) i.copy(status = "pending") else i)
  }

  def markAsRedo(item: Task): Unit = {
    items = items.map(i => if (i == item) i.copy(redo = true) else i)
  }

  def listAll(): String = {
   items.mkString
  }
  
  def listAllDoneTasks(): String = {
    items.filter(_.status == "done").mkString
  }
  
  def listAllNotDoneTasks(): String = {
    items.filter(_.status == "pending").mkString
  }
}

package grocery.domain

import org.scalatest.funsuite.AnyFunSuite

class GroceryTest extends AnyFunSuite {
  test("Grocery.addItem") {
    val grocery = Grocery()
    val task = Task("Prepare white bread", "pending", "high", false)
    grocery.addItem(task)
    assert(grocery.items.contains(task))
  }

  test("Grocery.removeItem") {
    val grocery = Grocery()
    val task = Task("Prepare white bread", "pending", "high", false)
    grocery.addItem(task)
    grocery.removeItem(task)
    assert(!grocery.items.contains(task))
  }

  test("Grocery.markAsDone") {
    val grocery = Grocery()
    val task = Task("Prepare white bread", "pending", "high", false)
    grocery.addItem(task)
    grocery.markAsDone(task)
    assert(grocery.items.exists(_.status == "done"))
  }

  test("Grocery.markAsNotDone") {
    val grocery = Grocery()
    val task = Task("Prepare white bread", "done", "high", false)
    grocery.addItem(task)
    grocery.markAsNotDone(task)
    assert(grocery.items.exists(_.status == "pending"))
  }

  test("Grocery.markAsRedo") {
    val grocery = Grocery()
    val task = Task("Prepare white bread", "done", "high", false)
    grocery.addItem(task)
    grocery.markAsRedo(task)
    assert(grocery.items.exists(_.redo))
  }

  test("Grocery.add multiple tasks") {
    val grocery = Grocery()
    val task1 = Task("Prepare white bread", "pending", "high", false)
    val task2 = Task("Prepare brown bread", "pending", "high", false)
    grocery.addItem(task1)
    grocery.addItem(task2)
    assert(grocery.items.length == 2)
  }

  test("Grocery.listAll available tasks"){
    val grocery = Grocery()
    val task1 = Task("Prepare white bread", "pending", "high", false)
    val task2 = Task("Prepare brown bread", "pending", "high", false)
    grocery.addItem(task1)
    grocery.addItem(task2)
    assert(grocery.listAll() == "Task(Prepare white bread,pending,high,false)Task(Prepare brown bread,pending,high,false)")
  }
}

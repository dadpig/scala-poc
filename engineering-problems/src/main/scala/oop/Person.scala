package oop

class Person (private val name: String, val age: Int, var friends: List[Person]) {


  def addFriend(name: String): Unit = {
    if (!this.friends.exists(_.name == name)) {
      this.friends = this.friends :+ new Person(name, 0, List())
    }
  }

  def removeFriend(name: String): Unit = {
    val updatedFriends = friends.filterNot(_.name == name)
    this.friends = updatedFriends

  }

  private def listFriendsNames(): List[String] = {
    this.friends.map(_.name)
  }

  override def toString: String = {
    s"Person(name=$name, age=$age, friends=${listFriendsNames()})"
  }
}
object PersonApp {
  def main(args: Array[String]): Unit = {
    val person = new Person("John", 30, List())
    println(person)
    person.addFriend("Paul")
    person.addFriend("George")
    person.addFriend("Ringo")


    println(person)

  }
}
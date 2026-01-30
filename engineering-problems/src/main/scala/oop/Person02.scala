package oop

class Person02 (private val name: String, val age: Int, var friends: List[Person02]) {

  private def getName: String = name
  private def getAge: Int = age

  def personWithMostFriends(people: List[Person02]): Option[Person02] = {
    people match {
      case Nil => None
      case _ => Some(people.maxBy(_.friends.size))
    }
  }
  def personWithLessFriends(people: List[Person02]): Option[Person02] = {
    people match {
      case Nil => None
      case _ => Some(people.minBy(_.friends.size))
    }
  }
  def oldestFriend(): Option[Person02] = {
    friends match {
      case Nil => None
      case _ => Some(friends.maxBy(_.getAge))
    }
  }
  def addFriend(friend: Person02): Unit = {
    if (!this.friends.exists(_.getName == friend.getName)) {
      this.friends = this.friends :+ friend
    }
  }
  def addFriendByName(name: String): Unit = {
    if (!this.friends.exists(_.getName == name)) {
      this.friends = this.friends :+ new Person02(name, 0, List())
    }
  }
  def removeFriend(name: String): Unit = {
    this.friends = friends.filterNot(_.getName == name)
  }
  private def listFriendsNames(): List[String] = {
    this.friends.map(_.getName)
  }
  override def toString: String = {
    s"Person02(name=$getName, age=$getAge, friends=${listFriendsNames()})"
  }

}

object Person02App {
  def main(args: Array[String]): Unit = {
    val person = new Person02("John", 30, List())
    println(person)
    person.addFriendByName("Paul")
    println(person)
    person.addFriend(new Person02("George", 28, List()))
    println(person)
    person.removeFriend("Paul")
    println(person)

    val friend1 = new Person02("Alice", 25, List())
    val friend2 = new Person02("Bob", 27, List())
    val friend3 = new Person02("Charlie", 22, List())

    val people = List(
      new Person02("Dave", 30, List(friend1, friend2)),
      new Person02("Eve", 35, List(friend1)),
      new Person02("Frank", 28, List(friend1, friend2, friend3))
    )

    println(s"Person with most friends: ${person.personWithMostFriends(people)}")
    println(s"Person with less friends: ${person.personWithLessFriends(people)}")

    person.friends = List(friend1, friend2, friend3)
    println(s"Oldest friend: ${person.oldestFriend()}")
  }
}



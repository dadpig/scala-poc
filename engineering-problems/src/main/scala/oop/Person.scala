package oop

class Person (private val name: String, val age: Int, var friends: List[Person]) {

  def personWithMostFriends(people: List[Person]): Option[Person] = {
    if (people.isEmpty) None
    else Some(people.maxBy(_.friends.size))
  }

  def personWithLessFriends(people: List[Person]): Option[Person] = {
    if (people.isEmpty) None
    else Some(people.minBy(_.friends.size))
  }

  def oldestFriend(): Option[Person] = {
    if (friends.isEmpty) None
    else Some(friends.maxBy(_.age))
  }

  def addFriend(friend: Person): Unit = {
    if (!this.friends.exists(_.name == friend.name)) {
      this.friends = this.friends :+ friend
    }
  }

  def addFriendByName(name: String): Unit = {
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
    person.addFriendByName("Paul")
    println(person)
    person.addFriendByName("George")
    println(person)
    person.addFriendByName("Ringo")
    println(person)
    person.addFriendByName("Paul")
    println(person)
    person.removeFriend("George")
    println(person)
    person.addFriend(new Person("Yoko", 28, List()))
    println(person)
    person.addFriend(new Person("Ringo", 32, List()))
    println(person)
    println(person.oldestFriend());
    person.addFriend(new Person("Bingo", 32, List()))
    println(person.oldestFriend());

  }
}
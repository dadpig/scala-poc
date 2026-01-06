package oop

class PersonNew (private val name: String, val age: Int, var friends: List[PersonNew]) {

  private def getName: String = name
  private def getAge: Int = age

  def personWithMostFriends(people: List[PersonNew]): Option[PersonNew] = {
    people match {
      case Nil => None
      case _ => Some(people.maxBy(_.friends.size))
    }
  }

  def personWithLessFriends(people: List[PersonNew]): Option[PersonNew] = {
    people match {
      case Nil => None
      case _ => Some(people.minBy(_.friends.size))
    }
  }

  def oldestFriend(): Option[PersonNew] = {
    friends match {
      case Nil => None
      case _ => Some(friends.maxBy(_.getAge))
    }
  }

  def addFriend(friend: PersonNew): Unit = {
    if (!this.friends.exists(_.getName == friend.getName)) {
      this.friends = this.friends :+ friend
    }
  }

  def addFriendByName(name: String): Unit = {
    if (!this.friends.exists(_.getName == name)) {
      this.friends = this.friends :+ new PersonNew(name, 0, List())
    }
  }

  def removeFriend(name: String): Unit = {
    this.friends = friends.filterNot(_.getName == name)
  }

  private def listFriendsNames(): List[String] = {
    this.friends.map(_.getName)
  }

  override def toString: String = {
    s"PersonNew(name=$getName, age=$getAge, friends=${listFriendsNames()})"
  }
}
object PersonNewApp {
  def main(args: Array[String]): Unit = {
    val person = new PersonNew("John", 30, List())
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
    person.addFriend(new PersonNew("Yoko", 28, List()))
    println(person)
    person.addFriend(new PersonNew("Ringo", 32, List()))
    println(person)
    println(person.oldestFriend());
    person.addFriend(new PersonNew("Bingo", 32, List()))
    println(person.oldestFriend());

  }
}
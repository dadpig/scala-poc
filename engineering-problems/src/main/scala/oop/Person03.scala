package oop

class Person03 (private val name: String, val age: Int, var friends: List[Person03]) {

 
  private def getName: String = name
  private def getAge: Int = age

  def personWithMostFriends(people: List[Person03]): Option[Person03] = {
    people match {
      case Nil => None
      case _ => Some(people.maxBy(_.friends.size))
    }
  }

  def personWithLessFriends(people: List[Person03]): Option[Person03] = {
    people match {
      case Nil => None
      case _ => Some(people.minBy(_.friends.size))
    }
  }

  def oldestFriend(): Option[Person03] = {
    friends match {
      case Nil => None
      case _ => Some(friends.maxBy(_.getAge))
    }
  }

  def addFriend(friend: Person03): Unit = {
    if (!this.friends.exists(_.getName == friend.getName)) {
      this.friends = this.friends :+ friend
    }
  }

  def addFriendByName(name: String): Unit = {
    if (!this.friends.exists(_.getName == name)) {
      this.friends = this.friends :+ new Person03(name, 0, List())
    }
  }

  def removeFriend(name: String): Unit = {
    this.friends = friends.filterNot(_.getName == name)
  }

  private def listFriendsNames(): List[String] = {
    this.friends.map(_.getName)
  }

  override def toString: String = {
    s"Person03(name=$getName, age=$getAge, friends=${listFriendsNames()})"
  }
  
}
object Person03App {
  def main(args: Array[String]): Unit = {
    val person = new Person03("John", 30, List())
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
    person.addFriend(new Person03("Yoko", 28, List()))
    println(person)
    person.addFriend(new Person03("Ringo", 32, List()))
    println(person)
    println(person.oldestFriend());
    person.addFriend(new Person03("Bingo", 32, List()))
    println(person.oldestFriend());

  }
}
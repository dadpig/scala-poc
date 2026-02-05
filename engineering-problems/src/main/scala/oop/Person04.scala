package oop


trait Friendly {

  var friends: List[Person04]
  
  def addFriend(friend: Person04): Unit = {
    if (!this.friends.exists(_.getName == friend.getName)) {
      this.friends = this.friends :+ friend
    }
  }

  def addFriendByName(name: String): Unit = {
    if (!this.friends.exists(_.getName == name)) {
      this.friends = this.friends :+ new Person04(name, 0, List())
    }
  }

  def removeFriend(name: String): Unit = {
    this.friends = friends.filterNot(_.getName == name)
  }

  def oldestFriend(): Option[Person04] = {
    var oldestFriendlyPerson = friends.head
    for (friend <- friends) {
      if (friend.age > oldestFriendlyPerson.age) {
        oldestFriendlyPerson = friend
      }
    }
    Some(oldestFriendlyPerson)
  }
}

class Person04 (private val name: String, val age: Int, val friends: List[Person04]) extends Friendly {



  def getName: String = name
  def getAge: Int = age

  def personWithMostFriends(people: List[Person04]): Option[Person04] = {
    var moreFriendlyPerson = people.head
    for (person <- people) {
      if (person.friends.size > moreFriendlyPerson.friends.size) {
        moreFriendlyPerson = person
      }
    }
    Some(moreFriendlyPerson)
  }

  def personWithLessFriends(people: List[Person04]): Option[Person04] = {
    var lessFriendlyPerson = people.head
    for (person <- people) {
      if (person.friends.size < lessFriendlyPerson.friends.size) {
        lessFriendlyPerson = person
      }
    }
    Some(lessFriendlyPerson)
  }


  private def listFriendsNames(): List[String] = {
    this.friends.map(_.getName)
  }

  override def toString: String = {
    s"Person04(name=$getName, age=$getAge, friends=${listFriendsNames()})"
  }

}
object Person04App {
  def main(args: Array[String]): Unit = {
    val person = new Person04("John", 30, List())
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
    person.addFriend(new Person04("Yoko", 28, List()))
    println(person)
    person.addFriend(new Person04("Ringo", 32, List()))
    println(person)
    println(person.oldestFriend());
    person.addFriend(new Person04("Bingo", 32, List()))
    println(person.oldestFriend());

  }
}
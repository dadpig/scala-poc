package oop



class Person05 (private val name: String, val age: Int, var friends: List[Person05]) {

  def getName: String = name

  def getAge: Int = age

  def getFriends: List[Person05] = friends

  def addFriend(friend: Person05): Unit = {
    if (!this.friends.exists(_.getName == friend.getName)) {
      this.friends = this.friends :+ friend
    }
  }

  def personWithMostFriends(people: List[Person05]): Option[Person05] = {
    var moreFriendlyPerson = people.head
    for (person <- people) {
      if (person.friends.size > moreFriendlyPerson.friends.size) {
        moreFriendlyPerson = person
      }
    }
    Some(moreFriendlyPerson)
  }

  def addFriendByName(name: String): Unit = {
    if (!this.friends.exists(_.getName == name)) {
      this.friends = this.friends :+ new Person05(name, 0, List())
    }
  }

  def personWithLessFriends(people: List[Person05]): Option[Person05] = {
    var lessFriendlyPerson = people.head
    for (person <- people) {
      if (person.friends.size < lessFriendlyPerson.friends.size) {
        lessFriendlyPerson = person
      }
    }
    Some(lessFriendlyPerson)
  }


  def removeFriend(name: String): Unit = {
    this.friends = friends.filterNot(_.getName == name)
  }

  def oldestFriend(): Option[Person05] = {
    var oldestFriendlyPerson = friends.head
    for (friend <- friends) {
      if (friend.age > oldestFriendlyPerson.age) {
        oldestFriendlyPerson = friend
      }
    }
    Some(oldestFriendlyPerson)
  }

  private def listFriendsNames(): List[String] = {
    this.friends.map(_.getName)
  }

  override def toString: String = {
    s"Person05(name=$getName, age=$getAge, friends=${listFriendsNames()})"
  }

}
object Person05App {
  def main(args: Array[String]): Unit = {
    val person = new Person05("John", 30, List())
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
    person.addFriend(new Person05("Yoko", 28, List()))
    println(person)
    person.addFriend(new Person05("Ringo", 32, List()))
    println(person)
    println(person.oldestFriend());
    person.addFriend(new Person05("Bingo", 32, List()))
    println(person.oldestFriend());

  }
}
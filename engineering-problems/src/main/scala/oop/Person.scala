package oop

class Person (private val name: String, val age: Int, val friends: List[Person]) {


  //Refactor the code so you dont allow the same friend to be added twice.
  def addFriend(name: String): Unit = {
    if (!friends.exists(_.name == name))
      this.friends.updated(friends.length, new Person(name, 0, List()))
  }

  def removeFriend(name: String): Person = {
    val updatedFriends = friends.filterNot(_.name == name)
    new Person(this.name, this.age, updatedFriends)
  }

  def getFriends(): List[String] = {
    friends.map(_.name)
  }

  override def toString: String = s"Person(name=$name, age=$age, friends=[${getFriends().mkString(", ")}])"




}

object PersonApp {
  def main(args: Array[String]): Unit = {
    val person = new Person("John", 30, List())
    person.addFriend("Paul")
    person.addFriend("George")
    person.addFriend("Ringo")


    println(person)

  }
}
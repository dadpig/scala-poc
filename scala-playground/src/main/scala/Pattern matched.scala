abstract class Animal

case class Mammal(name: String, fromSea: Boolean) extends Animal

case class Bird(name: String) extends Animal

case class Fish(name: String) extends Animal


def caseClassesPatternMatching(animal: Animal): String = {
  animal match {
    case Mammal(name, fromSea) => s"I'm a $name, a kind of mammal. Am I from the sea? $fromSea"
    case Bird(name) => s"I'm a $name, a kind of bird"
    case _ => "I'm an unknown animal"
  }
}

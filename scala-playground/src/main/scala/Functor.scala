object FunctorR:

trait Functor[C[_]] {
  def map[A, B](container: C[A])(f: A => B): C[B]
}

given listFunctor as Functor[List] {
  override def map[A, B](container: List[A])(f: A => B) = container.map(f)
}

def do10x[C[_]](container: C[Int])(using functor: Functor[C]) = functor.map(container)(_ * 10)

do10x(List(1,2,3)) // 10,20,30

trait Tree[+T]

object Tree {
  def leaf[T](value: T): Tree[T] = Leaf(value)
  def branch[T](value: T, left: Tree[T], right: Tree[T]): Tree[T] = Branch(value, left, right)
}

case class Leaf[+T](value: T) extends Tree[T]
case class Branch[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

given treeFunctor as Functor[Tree] {
  override def map[A, B](container: Tree[A])(f: A => B) = container match {
    case Leaf(value) => Leaf(f(value))
    case Branch(value, left, right) => Branch(f(value), left.map(f), right.map(f))
  }
}

val tree =
  Tree.branch(1,
    Tree.branch(2,
      Tree.leaf(3),
      Tree.leaf(4)),
    Tree.leaf(5)
  )

val tenxTree = do10x(tree)//10,20,30,40,50

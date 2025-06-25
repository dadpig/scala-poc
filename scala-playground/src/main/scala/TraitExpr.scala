trait Expr

case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr)extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


val v = Var("x")
val op = BinOp("+", Num(1), v)

print(v.name)// "x"
print(op.left) //Num(1.0)
print(op.right == Var("x")) //true

//pattern matcher
def simplifyTop(expr: Expr): Expr = {
  expr match
    case UnOp("-", UnOp("-", e)) => e //double negation
    case BinOp("+", e, Num(0)) => e //Adding zero
    case BinOp("*", e, Num(1)) => e //multiply by one
    case _ => expr
}

print (simplifyTop(op))

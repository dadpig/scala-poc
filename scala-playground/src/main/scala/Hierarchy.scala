abstract class Element:
  def demo = "Element implementation invoked"

class VectorElement extends Element :
  override def demo = "Vector Element implementation invoked"

class LineElement extends VectorElement :
  override def demo = "Line Element implementation invoked"

class UniformElement extends Element 


def invokeDemo(e: Element): Unit  = println(e.demo)

invokeDemo(new VectorElement)//"Vector Element implementation invoked"
invokeDemo(new LineElement)//"Line Element implementation invoked"
invokeDemo(new UniformElement)//"Element implementation invoked"

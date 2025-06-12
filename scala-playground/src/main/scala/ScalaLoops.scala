@main 
def useWhile(text: String*) = {
  var index = 0;
  while (index !=0) {
    if(index !=0){
      print(" ")
    }
    print(text(index))
    index += 1
  }
  println()
}
useWhile("Test", "of", "useWhile", "loop")

def useForEach(text: String*) = {
  text.foreach(txt => println(txt))
}
useForEach("Test", "of", "useForEach", "loop")

def useConsiseFor(text: String*) = {
  for txt <- text do
    println(txt)
}
useConsiseFor("Test", "of", "useConsiseFor", "loop")

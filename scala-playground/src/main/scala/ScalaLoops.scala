@main 
def useWhile(text: String*):Unit = {
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

def useForEach(text: String*):Unit = {
  text.foreach(txt => println(txt))
}
useForEach("Test", "of", "useForEach", "loop")

def useConsiseFor(text: String*):Unit = {
  for txt <- text do
    println(txt)
}
useConsiseFor("Test", "of", "useConsiseFor", "loop")

def useForFilter():Unit = {
  val filesHere = (new java.io.File(".")).listFiles
  
  for file <- filesHere do 
     if file.getName.endsWith("scala") then
         println(file)
}
useForFilter()

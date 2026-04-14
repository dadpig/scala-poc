package sort

object DPK12_08 {

   def insertionSort(input:List) : List{

     for(i <- 0 until input.length){
      var aux = i+1

      while(aux > 1 && input(aux)<input(aux-1)
              && aux<input.length){
        var ordered =input(aux)
        input(aux)=input(aux-1)
        input(aux-1)=ordered
        aux-=1
      }
    }

   }




  def main(args: Array[String]): Unit = {
    val input =  Array(5,5,7,4,8,3,2,1)
    //val result = quicksort(input)
    println(s" list: ${input.mkString(", ")}")
   // println(s"Sorted list: ${result.mkString(", ")}")
  }
}

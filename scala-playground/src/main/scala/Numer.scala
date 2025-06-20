object Numer:

  def containsNeg(nums: List[Int]): Boolean{
    var exists = false
    for num <- nums do
      if num < 0 then
          exists = true
    exists
  }

  def containsOdd(nums: List[Int]): Boolean{
    var exists = false
    for num <- nums do
      if num % 2 == 1 then
        exists = true
    exists
  }


Numer.containsNeg(List(0, 1, 2, 3)) //false
Numer.containsNeg(List(0, 1, -2, 3)) //true

Numer.containsOdd(List(0, 1, 2, 3)) //true
Numer.containsOdd(List(2, 4, 22, 32)) //false


/* using exists from List to simplify avoiding boiler plate code
def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
*/

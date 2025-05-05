case class TaironeString (charArray: Array[Char]) {

  def toArray: Array[Char] = charArray

  def forEach(): Unit = {
    print("foreach: ")
    for (c <- charArray) print( "'" + c + "' ")
    println("")
  }

  def reverse: Array[Char] = {
    val reversed = new Array[Char](charArray.length)
    for (i <- charArray.indices)//range from 0 to charArray.length - 1
      reversed(i) = charArray(charArray.length - 1 - i)//copy the last element to the first element of reversed array
    reversed
  }

  def iterator: Iterator[Char] = {
    new Iterator[Char] {
      private var index = 0

      def hasNext: Boolean = index < charArray.length

      def next: Char = {
        val result = charArray(index)
        index += 1
        result
      }
    }
  }

  def length: Int = charArray.length

  def charAt(index: Int): Char =  charArray(index)

  def equals(other: TaironeString): Boolean = charArray.sameElements(other.toArray)

  def isEmpty: Boolean = {
    if (charArray.length == 0) true
    else false
  }

  def replace(oldChar: Char, newChar: Char): Array[Char] = {
    val replaced = new Array[Char](charArray.length)
    for (i <- charArray.indices)
      if (charArray(i) == oldChar) replaced(i) = newChar
      else replaced(i) = charArray(i)
    replaced
  }


  def substring(start: Int, end: Int): Array[Char] = {
    val sub = new Array[Char](end - start)
    for (i <- start until end) sub(i - start) = charArray(i)
    sub
  }

  def toJson: String = {
    val json = new StringBuilder
    json.append("{ string = ")
    for (i <- charArray.indices) {
      json.append("\"" + charArray(i) + "\"")
      if (i < charArray.length - 1) json.append(",")
    }
    json.append("}")
    json.toString()
  }

  def indexOf(c: Char): Int = charArray.indexOf(c)


  override def hashCode(): Int = {
    var result = 1
    for (c <- charArray) result = 97 * result + c
    result
  }


  //trim the string
  def trim: Array[Char] = {
    //count the number of spaces
    var count = 0
    for (i <- charArray.indices) {
      if (charArray(i) == ' ') count += 1
    }

    val trimmed = new Array[Char](charArray.length - count)
    //Need this auxiliar variable to keep the index of the trimmed array
    var indTrim = 0
    for (i <- charArray.indices) {
      if(charArray(i) != ' ') {
        trimmed(indTrim) = charArray(i)
        indTrim += 1
      }
    }
    trimmed
  }


  def foreach(f: Char => Unit): Unit = {
    print("foreach with function: ")
    for (c <- charArray){
      f(c)
    }
    println("")
  }

  def replace(old: TaironeString, newString: TaironeString): TaironeString = {
    val index = indexOfSlice(old)
    if (index == -1) this
    else {
      val newCharArray = new Array[Char](charArray.length - old.length + newString.length)
      for (i <- 0 until index) newCharArray(i) = charArray(i)
      for (i <- 0 until newString.length) newCharArray(index + i) = newString.charAt(i)
      for (i <- index + old.length until charArray.length) newCharArray(i - old.length + newString.length) = charArray(i)
      TaironeString(newCharArray)
    }
  }

  def indexOfSlice(string: TaironeString): Int = {
    for (i <- 0 to charArray.length - string.length) {
      var found = true
      for (j <- 0 until string.length) {
        if (charArray(i + j) != string.charAt(j)) {
          found = false
        }
      }
      if (found) return i
    }
    -1
  }

}




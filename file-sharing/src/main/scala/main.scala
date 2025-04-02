import com.file.sharing.control.FileManager

@main
def main(): Unit =
  println("Hello world!")
  //Build a FileShare System (save files, restore files, delete files, listFiles, Search) with encryption


  FileManager().listFilesFromDir("").forEach(println)

package com.file.sharing.control

import java.nio.file.{FileSystems, Files, Path}
import java.util
import scala.jdk.javaapi.CollectionConverters
import scala.jdk.CollectionConverters.*


class FileManager {

  //Build a FileShare System (save files, restore files, delete files, listFiles, Search) with encryption

  val baseDir = "src/main/resources/"

  def listFilesFromDir(directory: String): util.ArrayList[String] = {

    var list = util.ArrayList[String]()

    val dir = FileSystems.getDefault.getPath(baseDir+directory)
    if (Files.list(dir).count().>(0)) {
      //Files.list(dir).iterator().asScala.foreach(println)

      var it = Files.list(dir).iterator().asScala
      while it.hasNext do
           list.add(it.next().toString)



    }else {
      list.add(f"No files available at $baseDir...")
    }

    list
  }
}

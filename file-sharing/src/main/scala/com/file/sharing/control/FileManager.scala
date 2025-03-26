package com.file.sharing.control

import java.nio.file.{FileSystems, Files}
import scala.io.Source
import scala.jdk.javaapi.CollectionConverters


import scala.jdk.CollectionConverters.*


class FileManager {

  //Build a FileShare System (save files, restore files, delete files, listFiles, Search) with encryption

  val baseDir = "src/main/resources/"

  def listFilesFromDir(directory: String): Seq[String] = {
    val list = new java.util.ArrayList[String]()
    val dir = FileSystems.getDefault.getPath(baseDir+directory)
    if (Files.list(dir).count().>(0)) {
      //Files.list(dir).iterator().asScala.foreach(println)
      //Files.list(dir).forEach(i =>list.add(i))

    }else {list.add(f"No files available at $baseDir...")}

    return CollectionConverters.asScala(list).toSeq
  }
}

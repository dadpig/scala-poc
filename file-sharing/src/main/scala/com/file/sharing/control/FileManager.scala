package com.file.sharing.control

import java.nio.file.{FileSystems, Files, Path}
import java.util
import scala.jdk.javaapi.CollectionConverters
import scala.jdk.CollectionConverters.*


class FileManager {

  //Build a FileShare System (save files, restore files, delete files, listFiles, Search) with encryption

  private val baseDir = "src/main/resources/"

  def listFilesFromDir(directory: String): util.ArrayList[String] = {

    val list = util.ArrayList[String]()
    val dir = FileSystems.getDefault.getPath(baseDir+directory)
    if (Files.list(dir).count().>(0)) {
      val it = Files.list(dir).iterator().asScala
      while it.hasNext do
           list.add(it.next().toString)
    }else {
      list.add(f"No files available at $baseDir...")
    }
    list
  }

  def createFile(content: String, fileName: String): Boolean = {
    var fileWasCreated = false
    val filePath = FileSystems.getDefault.getPath(baseDir+fileName)
    Files.writeString(filePath, content)
    fileWasCreated = true
    fileWasCreated
  }

  def createDir(dirName: String)  Boolean = {
    var dirWasCreated = false
    /*if (Files.exists(FileSystems.getDefault.getPath(baseDir+dirName))) {
      println("Directory already exists")
    }*/
    val dirPath = FileSystems.getDefault.getPath(baseDir+dirName)
    Files.createDirectory(dirPath)
    dirWasCreated = true
    dirWasCreated
  }

  def readFile(fileName: String) = {
    val filePath = FileSystems.getDefault.getPath(baseDir+fileName)
    Files.readString(filePath)
  }
}

package com.file.sharing.control

import java.nio.charset.Charset
import java.nio.file.{FileSystems, Files}
import java.util
import scala.jdk.CollectionConverters.*


class FileManager {

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
    Files.write(filePath, encryptFileContent(content).getBytes(Charset.forName("UTF-8")))
    fileWasCreated = true
    fileWasCreated
  }

  def createDirectory(fileName: String): Boolean = {
    var directoryWasCreated = false
    val filePath = FileSystems.getDefault.getPath(baseDir + fileName)
    Files.createDirectory(filePath)
    directoryWasCreated = true
    directoryWasCreated
  }

  def readFileContent(fileName: String): String = {
    val filePath = FileSystems.getDefault.getPath(baseDir+fileName)
    decryptFileContent(Files.readAllLines(filePath, Charset.forName("UTF-8")).asScala.mkString("\n"))
  }

  def deleteFile(fileName: String): Boolean = {
    val filePath = FileSystems.getDefault.getPath(baseDir+fileName)
    Files.deleteIfExists(filePath)
  }

  def searchFile(fileName: String): util.ArrayList[String] = {
    val list = util.ArrayList[String]()
    val dir = FileSystems.getDefault.getPath(baseDir)
    if (Files.list(dir).count().>(0)) {
      val it = Files.list(dir).iterator().asScala
      while it.hasNext do
        val file = it.next()
        if file.getFileName.toString.contains(fileName) then
          list.add(file.toString)
    }else {
      list.add(f"No files available at $baseDir...")
    }
    list
  }

  private def encryptFileContent(content: String): String = {
    content.map(c => (c + 17).toChar)
  }

  private def decryptFileContent(content: String): String = {
    content.map(c => (c - 17).toChar)
  }
}

package note.taking.system.domain

import java.time.LocalDateTime

class Note(name: String, content: Array[String], createdAt: LocalDateTime) {
  def getName: String = name
  def getContent: Array[String] = content
  def getCreatedAt: LocalDateTime = createdAt
  def addContent(newContent: String): Unit = {
    getContent.toList.addString(StringBuilder.newBuilder.mkString(newContent))
  }
}

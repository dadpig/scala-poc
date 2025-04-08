package note.taking.system.domain

import java.time.LocalDateTime

class Note(name: String, content: String, createdAt: LocalDateTime) {
  def getName: String = name
  def getContent: String = content
  def getCreatedAt: LocalDateTime = createdAt
}

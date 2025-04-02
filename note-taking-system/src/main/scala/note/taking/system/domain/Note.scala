package note.taking.system.domain

class Note(content: String, createdAt: Long) {
  def getContent: String = content
  def getCreatedAt: Long = createdAt
}

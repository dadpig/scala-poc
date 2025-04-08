package note.taking.system.service

import note.taking.system.domain.Note
class NoteManager(){

  private var notes: List[Note] = List()


  def addNote(noteName: String, content:String): Unit = {
    notes = notes :+ new Note(noteName, content, java.time.LocalDateTime.now())
  }

  def deleteNote(noteName: String): List[Note]  = {
    notes = notes.filterNot(_.getName == noteName)
    return notes
  }

  def getNotes(name: String): List[Note] = {
    if(name.isEmpty) return notes
    notes.filter(_.getName.contains(name))
  }
}

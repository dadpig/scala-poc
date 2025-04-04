package note.taking.system.service

import note.taking.system.domain.Note
class NoteManager(){

  private val notes: List[Note] = List()

  def editNote(noteName:String, content: String) = Boolen{
    var fileEdited = false;
    val note = notes.find(_.getName == noteName)
    if (note.isDefined) {
      note.+(content)
      fileEdited = true
    }
    fileEdited
  }
  def addNote(note: Note): Unit = {
    // Logic to add a note
  }

  def deleteNote(noteId: String): Unit = {
    // Logic to delete a note
  }

  def getNotes: List[String] = {
    // Logic to get all notes
    notes
  }
}

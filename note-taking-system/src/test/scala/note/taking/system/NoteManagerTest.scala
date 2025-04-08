package note.taking.system

import note.taking.system.service.NoteManager
import org.scalatest.funsuite.AnyFunSuite

class NoteManagerTest extends AnyFunSuite{

  test("Add one Note") {
    val manager = NoteManager()
    manager.addNote("note1", "My first Note")
    assert(manager.getNotes("note1").size == 1)
  }


  test("Add Two Notes") {
    val manager = NoteManager()
    manager.addNote("note1", "My first Note")
    manager.addNote("note2", "My second Note")
    assert(manager.getNotes("").size == 2)
  }


  test("List Two Notes") {
    val manager = NoteManager()
    manager.addNote("note1", "My first Note")
    manager.addNote("note2", "My second Note")
    assert(manager.getNotes("note1").exists(_.getContent == "My first Note"))
    assert(manager.getNotes("note2").exists(_.getContent == "My second Note"))
  }

  test("Delete one Note") {
    val manager = NoteManager()
    manager.addNote("note1", "My first Note")
    manager.addNote("note2", "My second Note")
    assert(manager.deleteNote("note1").size == 1)
    assert(manager.getNotes("note1").isEmpty)
    assert(manager.getNotes("note2").nonEmpty)
  }
}

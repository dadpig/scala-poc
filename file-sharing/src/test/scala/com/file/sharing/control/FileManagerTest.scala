package com.file.sharing.control



import org.scalatest.funsuite.AnyFunSuite

class FileManagerTest extends AnyFunSuite {

  test("listFilesFromDir should return a list of files") {
    val fileManager = new FileManager()
    val files = fileManager.listFilesFromDir("")
    assert(files.size() > 0)
    assert(files.get(0) == "No files available at src/main/resources/...")
  }

  test("createFile should create a file") {
    val fileManager = new FileManager()
    val isCreated = fileManager.createFile("Test content", "testFile.txt")
    assert(isCreated)
    val isRemoved = fileManager.deleteFile("testFile.txt")
    assert(isRemoved)
  }

  test("createDirectory should create a directory") {
    val fileManager = new FileManager()
    val isCreated = fileManager.createDirectory("testDir")
    assert(isCreated)
    val isRemoved = fileManager.deleteFile("testDir")
    assert(isRemoved)
  }

  test("readFileContent should read the content of a file") {
    val fileManager = new FileManager()
    val isCreated = fileManager.createFile("Test content", "testFile.txt")
    assert(isCreated)
    val content = fileManager.readFileContent("testFile.txt")
    assert(content == "Test content")
    val isRemoved = fileManager.deleteFile("testFile.txt")
    assert(isRemoved)
  }


  test("searchFile should return a list of files matching the search criteria") {
    val fileManager = new FileManager()

    assert(fileManager.createFile("Test content", "test_File.txt"))
    assert(fileManager.createFile("Test content two", "test_File2.txt"))
    assert(fileManager.createFile("Main content", "main_File.txt"))
    assert(fileManager.createFile("Test content three", "test_File3.txt"))
    assert(fileManager.createFile("Test content four", "test_File4.txt"))
    assert(fileManager.createFile("", "empty_File.txt"))
    val files = fileManager.searchFile("test")
    assert(files.size() > 0)
    assert(files.size() == 4)

    assert(fileManager.deleteFile("test_File.txt"))
    assert(fileManager.deleteFile("test_File2.txt"))
    assert(fileManager.deleteFile("main_File.txt"))
    assert(fileManager.deleteFile("test_File3.txt"))
    assert(fileManager.deleteFile("test_File4.txt"))
    assert(fileManager.deleteFile("empty_File.txt"))
  }
}
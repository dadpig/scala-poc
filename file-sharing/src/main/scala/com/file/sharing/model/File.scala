package com.file.sharing.model

case class File(name: String, content: String, size: Long, path: String, isDirectory: Boolean, isOpen: Boolean) {

  def this(name: String, content: String, size: Long, path: String, isDirectory: Boolean) = this(name, content, size, path, isDirectory, false)

  def addContent(content: String): File = {
    new File(name, this.content + content, size + content.length, path, isDirectory, isOpen)
  }

  def move(newPath: String): File = {
    new File(name, content, size, newPath, isDirectory, isOpen)
  }


}


import zio.*
import zio.stream.*

import java.nio.file.Paths

import zio._

object CSVReaderApp extends ZIOAppDefault {

  case class Person(id: Int, name: String)

  def parseLine(line: String): Option[Person] = {
    Console.printLine(line)
    line.split(",") match {
      case Array(id, name) if id.forall(_.isDigit) =>
        Some(Person(id.toInt, name))
      case _ => None
    }
  }

  def readCSVFile(filePath: String): ZStream[Any, Throwable, Person] = {


    ZStream.fromFile(Paths.get(filePath).toFile)
      .via(ZPipeline.utf8Decode >>> ZPipeline.splitLines)
      .drop(1) // Skip header id,name
      .map(line => parseLine(line))
      .collect { case Some(person) => person }

  }
  val fileName = "/Users/tlopesdeoliveira/GitProjects/pocs/zio-csv-reader/src/main/resources/data.csv"


  def run =
    for {
      _ <- ZIO.log("Application started!")
      _ <- readCSVFile(fileName).foreach(person => Console.printLine(s"ID: ${person.id}, Name: ${person.name}"))
      _ <- ZIO.log("Application is about to exit!")
    } yield ()

  def readFromConsoleExample = for {
    _ <- Console.printLine("Hello! What is your name?")
    n <- Console.readLine
    _ <- Console.printLine("Hello, " + n + ", good to meet you!")
  } yield ()


}

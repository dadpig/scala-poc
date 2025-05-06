import zio._
import zio.*
import zio.http._
import zio.schema._

import zio.stream._
import scala.util.Random
import java.io.*



object RequestStreaming extends ZIOAppDefault {

  def printLine(line: String): UIO[Unit] =
    ZIO.succeed(println(line))
  // Create HTTP route which echos back the request body
  val app = Routes(Method.POST / "echo" -> handler { (req: Request) =>
    val stream = req.body.asStream


    // tried to get this from body but without luck
    val chunkSize = 10
    val fillValue = 3

    val chunk: Chunk[Int] = Chunk.fill(chunkSize)(fillValue * Random.between(1, 30))

    val s3: ZStream[Any, Throwable, Int]    = ZStream.fromChunk(chunk)

    // s3.filter(_ % 2 == 0).run(ZSink.sum)
    // s3.filter(_ % 2 == 0).tap(x => printLine(s"after mapping: $x"))
    s3.tap(x => printLine(s"after mapping: $x"))

    val streamz: ZStream[Any, IOException, Int] =
      ZStream(1, 2, 3)
        .tap(x => printLine(s"before mapping: $x"))
        .map(_ * 2)
        .tap(x => printLine(s"after mapping: $x"))
    val data = Body.fromStreamChunked(stream)

    Response(body = data)
  })

  // Run it like any simple app
  val run: UIO[ExitCode] =
    Server.serve(app).provide(Server.default).exitCode

    //test with curl -d '{"key1":"value1", "key2":"value2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/echo
}
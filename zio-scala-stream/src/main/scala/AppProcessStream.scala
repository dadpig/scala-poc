import com.zio.batch.BatchProcessStream
import zio.stream.{ZSink, ZStream}
import zio.{ExitCode, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object AppProcessStream extends ZIOAppDefault {

  private val myApp: ZStream[Any, Throwable, Int] = for {
    batch <- BatchProcessStream("input-data.csv").run
    _ <- ZStream.succeed("Finish")
  } yield 1

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] = {
    myApp.run(ZSink.sum[Int]).debug("sum")
  }
}


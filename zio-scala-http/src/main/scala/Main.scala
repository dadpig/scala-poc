
import BatchStatus.PENDING
import zio.*
import zio.http.*
import zio.json.*

enum BatchStatus:
case PENDING, RUNNING, DONE

object BatchStatus:
implicit val decoder: JsonDecoder[BatchStatus] =
  DeriveJsonDecoder.gen[BatchStatus]
implicit val encoder: JsonEncoder[BatchStatus] =
  DeriveJsonEncoder.gen[BatchStatus]

case class BatchRequest(name: String)

object BatchRequest:
implicit val decoder: JsonDecoder[BatchRequest] =
  DeriveJsonDecoder.gen[BatchRequest]
implicit val encoder: JsonEncoder[BatchRequest] =
  DeriveJsonEncoder.gen[BatchRequest]

case class BatchResponse(id: Int, name: String, status: BatchStatus)

object BatchResponse:
implicit val decoder: JsonDecoder[BatchResponse] =
  DeriveJsonDecoder.gen[BatchResponse]
implicit val encoder: JsonEncoder[BatchResponse] =
  DeriveJsonEncoder.gen[BatchResponse]

object Main extends ZIOAppDefault:
private val apps: Routes[Any, Response] = Routes(
  Method.POST / "batches" -> handler { (req: Request) =>
    for {
      body <- req.body.asString.orDie
      decoded = body.fromJson[BatchRequest]
      response <- decoded match {
        case Left(error) =>
          ZIO.fail(Response.text(error).status(Status.BadRequest))
        case Right(batchRequest) =>
          val batchResponse = BatchResponse(1, batchRequest.name, PENDING)
          ZIO.succeed(
            Response.json(batchResponse.toJson).status(Status.Created)
          )
      }
    } yield response
  }
)

def run: ZIO[Any, Throwable, Nothing] = Server.install(apps)
  .flatMap { port =>
    Console.printLine(s"Started on $port") *> ZIO.never
  }
  .provide(Server.defaultWithPort(8080))

@main
def main(): Unit = {
  println("Hello world!")
}


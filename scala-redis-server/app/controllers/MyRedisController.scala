package controllers

import model.Cache
import play.api.mvc._

import javax.inject._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MyRedisController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  //var memory: Cache

  val memory = new Cache()
  def allKeys(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val keys = memory.allKeys()
    Ok(keys.mkString)
  }
  def allValues(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val values = memory.allValues()
    Ok(values.mkString)
  }
  def allKeyValues(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(memory.toString)
  }
  def get(key: String): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val value = memory.get(key)
    value match {
      case Some(v) => Ok(v)
      case None => NotFound("Key not found")
    }
  }
  def set(key: String, value: String): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    memory.set(key, value)
    Ok("Key: "+key+" value: "+value+" set successfully")
  }

}
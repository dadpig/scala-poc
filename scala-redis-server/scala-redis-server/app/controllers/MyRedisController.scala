package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model.Cache
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class MyRedisController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  memory: Cache
  def this() = {
    this(ControllerComponents())
    memory = new Cache()
  }

  def allKeys(): Action[AnyContent] = Action {
    Ok(Jason.toJson(memory.allKeys()))
  }

  def allValues(): Action[AnyContent] = Action {
    Ok(Jason.toJson(memory.allValues()))
  }

  def get(key: String): Action[AnyContent] = Action {
    memory.get(key) match {
      case Some(value) => Ok(value)
      case None => NotFound(s"Key $key not found")
    }
  }

  def set(key: String, value: String): Action[AnyContent] = Action {
    memory.set(key, value)
    Ok(s"Key $key set to $value")
  }
}
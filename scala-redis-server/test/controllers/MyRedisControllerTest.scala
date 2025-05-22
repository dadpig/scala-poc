package controllers

import org.hamcrest.CoreMatchers.equalTo
import org.scalatest.Assertion
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.FakeRequest
import play.api.test._
import play.api.test.Helpers._
import play.test.WithApplication

class MyRedisControllerTest  extends PlaySpec
  with MockitoSugar with ScalaFutures {


  "test set one" in new WithApplication {
    def testSetOne(): Assertion = {
      val app = GuiceApplicationBuilder().build()
      val controller = app.injector.instanceOf[controllers.MyRedisController]
      val result = controller.set("one", "1")(FakeRequest())

      status(result) must equalTo(OK)
      contentAsString(result) must contain("one")
    }
  }




  "test set one, two" in new WithApplication {
    def testSetOneTwo(): Assertion = {
      val app = GuiceApplicationBuilder().build()
      val controller = app.injector.instanceOf[controllers.MyRedisController]
      val result = controller.set("one", "1")(FakeRequest())
      controller.set("two", "2")(FakeRequest())
      status(result) must equalTo(OK)
      contentAsString(result) must contain("one")
    }
  }



  "test get one" in new WithApplication {
    def testGetOne(): Assertion = {
      val app = GuiceApplicationBuilder().build()
      val controller = app.injector.instanceOf[controllers.MyRedisController]
      controller.set("one", "1")(FakeRequest())
      val result =  controller.get("one")(FakeRequest())
      status(result) must equalTo(OK)
      contentAsString(result) must contain("one")
    }
  }



}

package example.service

import akka.actor.Actor
import example.Context
import org.json4s.{DefaultFormats, Formats}
import org.json4s.JsonAST.JObject
import org.json4s.jackson.JsonMethods._
import spray.routing.HttpService
import spray.httpx.Json4sSupport

class TemperatureServiceActor extends Actor with TemperatureService {
  implicit def json4sFormats: Formats = DefaultFormats

  def actorRefFactory = context

  def receive = runRoute(route)
}

trait TemperatureService extends HttpService with Json4sSupport {
  val route =
    path("temperature" / "report") {
    /*
    {
      "startTime":"1305435146712",
      "endTime":"1405435156712"
    }
    */
      post {
        entity(as[JObject]) { userData =>
          complete {
            val dataMap = userData.extract[JObject]

            val startTime = dataMap.values.get("startTime").mkString.toLong
            val endTime = dataMap.values.get("endTime").mkString.toLong

            Context.storeService.getByDate(startTime, endTime)
          }
        }
      }
    }~ path("temperature" / "add") {
    /*
    {
      "temperature":"25.5",
      "user":"jhon@gmail.com"
    }
    */
      post {
        entity(as[JObject]) { userData =>
          complete {
            val dataMap = userData.extract[JObject]

            val temperature = dataMap.values.get("temperature").mkString.toDouble
            val user = dataMap.values.get("user").mkString

            Context.storeService.add(temperature, user)

            parse("""{"response":"done"}""")
          }
        }
      }
    }
}

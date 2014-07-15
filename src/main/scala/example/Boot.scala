package example

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import example.dao.SquerylBootstrap
import example.service.TemperatureServiceActor
import spray.can.Http

object Boot extends App {
  //ActorSystem for histing our application
  implicit val system = ActorSystem("temperature-system")

  // create and start service actor
  val service = system.actorOf(Props[TemperatureServiceActor], "temperature-service")

  //init Squeryl Bootstrap
  SquerylBootstrap.initConcreteFactory

  // start a new HTTP server on port 8080
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}
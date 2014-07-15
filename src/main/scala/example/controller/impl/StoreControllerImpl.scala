package example.controller.impl

import example.controller.StoreController
import example.dao.Db
import example.dao.model.Temperature
import org.squeryl.PrimitiveTypeMode._

trait StoreControllerImpl extends StoreController {
  def add(temperature: Double, user: String): Unit = {
    val temperatureObject = new Temperature()
    temperatureObject.user = user
    temperatureObject.temperature = temperature
    temperatureObject.datetime = java.lang.System.currentTimeMillis

    transaction {
      Db.temperature.insert(temperatureObject)
    }
  }

  def getByDate(startTime: Long, endTime: Long): List[Temperature] = {
    transaction{
      val records = from(Db.temperature)(t => where((t.datetime gte startTime) and (t.datetime lte endTime)) select(t))
      records.toList
    }
  }
}

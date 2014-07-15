package example.dao

import example.dao.model.Temperature
import org.squeryl.Schema

object Db extends Schema {
  val temperature = table[Temperature]("archive")
}

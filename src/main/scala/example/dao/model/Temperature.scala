package example.dao.model

import org.apache.commons.lang.builder.ToStringBuilder
import org.squeryl.KeyedEntity

class Temperature(var id: Long, var datetime: Long, var user: String, var temperature: Double) extends KeyedEntity[Long] {
  def this() = this(0, 0, "", 0)

  override def toString = {
    new ToStringBuilder(this).
      append("id", id).
      append("datetime", datetime).
      append("user", user).
      append("temperature", temperature)
    toString
  }
}

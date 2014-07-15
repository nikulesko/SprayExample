package example.dao

import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.H2Adapter
import org.apache.commons.dbcp.BasicDataSource


object SquerylBootstrap {
  def initConcreteFactory {
    val jdbcDriver = "org.h2.Driver"

    val adapter = new H2Adapter

    val dbcp = new BasicDataSource()
    dbcp.setDriverClassName(jdbcDriver)
    dbcp.setUrl("jdbc:h2:file:temperature")

    dbcp.setValidationQuery("SELECT NOW()")
    dbcp.setTestOnReturn(true)
    dbcp.setTestOnBorrow(true)

    Class.forName(jdbcDriver)
    SessionFactory.concreteFactory = Some{()=>  Session.create(dbcp.getConnection, adapter)}
  }
}
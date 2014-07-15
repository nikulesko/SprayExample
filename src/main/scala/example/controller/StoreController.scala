package example.controller

import example.dao.model.Temperature

trait StoreController {
  def add(temperature: Double, user: String)

  def getByDate(startTime: Long, endTime: Long): List[Temperature]
}

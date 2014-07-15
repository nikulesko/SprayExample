package example

import example.controller.StoreController
import example.controller.impl.StoreControllerImpl

object Context extends StoreControllerImpl {
  def storeService: StoreController = new StoreControllerImpl {}
}

package com.app.controller


import org.scalatest.FunSuite

class MainControllerTest extends FunSuite {
   
  test("handles route"){
                             
      assert(new MainController().handles("/") == true)
  }
}
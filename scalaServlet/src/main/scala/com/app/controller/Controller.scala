package com.app.controller

trait Controller {
  def  handles(route: String) : Boolean
  def  execute(context: Context) 
}
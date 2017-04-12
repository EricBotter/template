package com.app.controller

import com.app.view.Layout

class MainController extends Controller {
	
  val ROUTE = "/"

	override def handles(route: String): Boolean = route.equals(ROUTE)

	override def execute(context: Context) {
		context.response.setContentType("text/html")
		context.response.setCharacterEncoding("UTF-8")

		context.response.getWriter.write(new Layout().build().render())
  }
}
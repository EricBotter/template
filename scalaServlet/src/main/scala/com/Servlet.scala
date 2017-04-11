package com

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.app.controller.MainController
import com.app.controller.Context
import javax.sql.DataSource
import javax.naming.InitialContext

class Servlet extends HttpServlet { 
  
  var ds : DataSource  = null
  
  override def init() {
	  ds = new InitialContext().lookup("java:/comp/env/jdbc/ds").asInstanceOf[DataSource]
  }
  
  override def service(request: HttpServletRequest, response: HttpServletResponse){
    for(c <- List(new MainController())){
      if(c.handles(request.getRequestURI)){
        c.execute(new Context(request, response))
      }
    }
  }
}
package com

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.app.controller.MainController
import com.app.controller.Context

class Servlet extends HttpServlet { 
   
  override def service(request: HttpServletRequest, response: HttpServletResponse){
    for(c <- List(new MainController())){
      if(c.handles(request.getRequestURI)){
        c.execute(new Context(request, response))
      }
    }
  }
}
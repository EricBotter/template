package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.List;
import java.util.stream.Collectors;

import seminar.Seminar;

public class CourseListLayout {

	String _htmlHeader = "<!doctype html>\n" + 
			"<html lang=\"en\">\n" + 
			" <head>\n" + 
			"  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" + 
			"  <meta charset=\"utf-8\">\n" + 
			"  <title>courses</title>\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
			"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
			"  <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css?v=1.0.0\" media=\"screen\">\n" + 
			"  <link rel=\"stylesheet\" href=\"/css/custom.css?v=1.0.0\">\n" + 
			"  <link rel=\"stylesheet\" href=\"/css/app.css?v=1.0.0\">\n" + 
			"  <!--[if lt IE 9]>\n" + 
			"    <script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js'></script>\n" + 
			"    <script src='https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js'></script>\n" + 
			"  <![endif]-->\n" + 
			" </head>\n" + 
			" <body>\n" + 
			"  <div class=\"navbar navbar-default navbar-fixed-top\">\n" + 
			"   <div class=\"container\">\n" + 
			"    <div class=\"navbar-header\">\n" + 
			"     <a href=\"/\" class=\"navbar-brand\">Seminar</a>\n" + 
			"     <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button>\n" + 
			"    </div>\n" + 
			"    <div class=\"navbar-collapse collapse\" id=\"navbar-main\">\n" + 
			"     <ul class=\"nav navbar-nav navbar-right\">\n" + 
			"      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"download\" aria-expanded=\"false\">Account <span class=\"caret\"></span></a>\n" + 
			"       <ul class=\"dropdown-menu\" aria-labelledby=\"download\">\n" + 
			"        <li><a href=\"/\">settings</a></li>\n" + 
			"        <li class=\"divider\"></li>\n" + 
			"        <li><a href=\"/\">logout</a></li>\n" + 
			"       </ul></li>\n" + 
			"     </ul>\n" + 
			"    </div>\n" + 
			"   </div>\n" + 
			"  </div>\n" + 
			"  <div class=\"container\">\n" + 
			"   <div class=\"page-header\" id=\"banner\">\n" + 
			"    <div class=\"row\">\n" + 
			"     <div class=\"col-lg-8 col-md-7 col-sm-6\">\n" + 
			"      <h1>Seminar</h1>\n" + 
			"      <p class=\"lead\">Manage your courses!</p>\n" + 
			"     </div>\n" + 
			"    </div>\n" + 
			"    <div class=\"row\">\n" + 
			"     <div class=\"col-lg-2 col-md-2 col-sm-3\">\n" + 
			"      <div class=\"list-group table-of-contents\">\n" + 
			"       <a class=\"list-group-item\" href=\"/course\">List</a>\n" + 
			"       <a class=\"list-group-item\" href=\"/course/create\">Create</a>\n" + 
			"      </div>\n" + 
			"     </div>\n" + 
			"     <div class=\"col-lg-8 col-md-8 col-sm-9\">\n" + 
			"      <table class=\"table table-striped\">\n" + 
			"       <thead>\n" + 
			"        <tr>\n" + 
			"         <th>id</th>\n" + 
			"         <th>name</th>\n" + 
			"         <th>location</th>\n" + 
			"         <th>totalSeats</th>\n" + 
			"         <th>start</th>\n" + 
			"        </tr>\n" + 
			"       </thead>\n" + 
			"       <tbody>";
	
	String _htmlFooter = "</tbody>\n" + 
			"      </table>\n" + 
			"     </div>\n" + 
			"    </div>\n" + 
			"   </div>\n" + 
			"   <footer>\n" + 
			"    <div class=\"row\">\n" + 
			"     <div class=\"col-lg-12\">\n" + 
			"      <p><a href=\"http://bootswatch.com/cerulean\" rel=\"nofollow\">Cerulean theme</a></p>\n" + 
			"      <p>Code released under the <a href=\"https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE\">MIT License</a>.</p>\n" + 
			"      <p>GmTechnologies</p>\n" + 
			"     </div>\n" + 
			"    </div>\n" + 
			"   </footer>\n" + 
			"  </div>\n" + 
			"  <script src=\"/js/jquery.min.js?v=1.0.0\"></script>\n" + 
			"  <script src=\"/js/bootstrap.min.js?v=1.0.0\"></script>\n" + 
			"  <script src=\"/js/custom.js?v=1.0.0\"></script>\n" + 
			" </body>\n" + 
			"</html>\n";
	
	public String buildAndRender(List<Seminar> seminars) {
		String content = seminars.stream().map(seminar ->
				tr(
					td(seminar.getId()),
					td(seminar.getName()),
					td(seminar.getLocation()),
					td(String.valueOf(seminar.getSeatsLeft())),
					td(seminar.getStartDateAsString())
				).render()
			).collect(Collectors.joining("\n"));
		
		return _htmlHeader + content + _htmlFooter;
	}
}

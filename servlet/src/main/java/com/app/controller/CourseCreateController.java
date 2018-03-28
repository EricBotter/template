package com.app.controller;

public class CourseCreateController extends CourseController {
	
	private final String _htmlPage = "<!DOCTYPE html>\n" + 
			"<html lang='en'>\n" + 
			"<head>\n" + 
			"<meta charset='utf-8'>\n" + 
			"<meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" + 
			"<meta name='viewport' content='width=device-width, initial-scale=1'>\n" + 
			"<title>Seminar</title>\n" + 
			"<link rel='stylesheet' href='/css/bootstrap.min.css'>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"<div class='container'>\n" + 
			"    <div class='row'>\n" + 
			"        <div class='col-md-6 col-md-offset-3'>\n" + 
			"            <h1 class='page-header text-center'>Contact Form Example</h1>\n" + 
			"            <form class='form-horizontal' role='form' method='post' action='create'>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='name' class='col-sm-2 control-label'>Name</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='text' class='form-control' id='name' name='name' placeholder='e.g. Introductory Seminar'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='number' class='col-sm-2 control-label'>Number</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='text' class='form-control' id='number' name='number' placeholder='e.g. 101'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='description' class='col-sm-2 control-label'>Description</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='text' class='form-control' id='description' name='description' placeholder='e.g. Introduction to the academy'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='date' class='col-sm-2 control-label'>Date</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='date' class='form-control' id='date' name='date' placeholder='e.g. 2018-03-04'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='location' class='col-sm-2 control-label'>Location</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='text' class='form-control' id='location' name='location' placeholder='e.g. Room 3, main building'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <label for='seats' class='col-sm-2 control-label'>Available Seats</label>\n" + 
			"                    <div class='col-sm-10'>\n" + 
			"                        <input type='number' class='form-control' id='seats' name='seats' placeholder='e.g. 200'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"                <div class='form-group'>\n" + 
			"                    <div class='col-sm-10 col-sm-offset-2'>\n" + 
			"                        <input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>\n" + 
			"                    </div>\n" + 
			"                </div>\n" + 
			"            </form>\n" + 
			"        </div>\n" + 
			"    </div>\n" + 
			"</div>\n" + 
			"<script src='/js/jquery.min.js'></script>\n" + 
			"<script src='/js/bootstrap.min.js'></script>\n" + 
			"</body>";

	@Override
	public boolean handles(String route) {
		return route.equals("/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		if (context.request().getMethod().equals("POST")) {
			String name = context.request().getParameter("name");
			String number = context.request().getParameter("number");
			String description = context.request().getParameter("description");
			String date = context.request().getParameter("date");
			String location = context.request().getParameter("location");
			String seats = context.request().getParameter("seats");
			setSeminar(name, number, description, date, location, seats);
			
			context.response().sendRedirect("html");
		} else
			writeBasicResponse(context, "text/html", _htmlPage);
	}

}

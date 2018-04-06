package com.app.controller.course;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.course.create.CourseCreationParameters;
import com.app.view.CourseCreateLayout;

import seminar.Seminar;

public class CourseCreateController extends Controller {
	
	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course/create");
	}

	@Override
	public void execute(Context context) throws Exception {
		if (context.request().getMethod().equals("POST")) {
			CourseCreationParameters params = new CourseCreationParameters(context.request());
			
			if (params.isWholeInputValid()) {
				addSeminar(context.connection(), params.getSeminar());
				context.response().sendRedirect("/course");
			} else {
				writeSimpleResponse(context, "text/html", new CourseCreateLayout().build(params).render());
			}
		} else
			writeSimpleResponse(context, "text/html", new CourseCreateLayout().buildEmpty().render());
	}
	
	private void addSeminar(Connection connection, Seminar s) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO Course(name, description, location, totalSeats, start) "
					+ "VALUES (?, ?, ?, ?, ?)"
				);
			ps.setString(1, s.getCourse().getName());
			ps.setString(2, s.getCourse().getDescription());
			ps.setString(3, s.getLocation());
			ps.setInt(4, s.getSeatsLeft());
			ps.setDate(5, new Date(s.getCourse().getStartDate().getTimeInMillis()));
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

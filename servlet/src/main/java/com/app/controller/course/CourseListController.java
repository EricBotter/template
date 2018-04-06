package com.app.controller.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.view.CourseListLayout;

import seminar.Course;
import seminar.Seminar;

public class CourseListController extends Controller {

	@Override
	public boolean handles(String route) {
		return routeCheckWithSlashTolerance(route, "/course") ||
			routeCheckWithSlashTolerance(route, "/");
	}

	@Override
	public void execute(Context context) throws Exception {
		writeSimpleResponse(context, "text/html",
				new CourseListLayout().buildAndRender(getSeminars(context.connection())));
	}

	private List<Seminar> getSeminars(Connection connection) {
		ArrayList<Seminar> output = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT id, name, description, location, totalSeats, start FROM Course"
				);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(rs.getDate(6));
				output.add(new Seminar(
						new Course(rs.getString(2), String.valueOf(rs.getInt(1)), rs.getString(3), gc),
						rs.getString(4),
						rs.getInt(5)
				));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Collections.unmodifiableList(output);
	}
}

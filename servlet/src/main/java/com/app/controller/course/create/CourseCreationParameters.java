package com.app.controller.course.create;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import seminar.Seminar;

public class CourseCreationParameters {
	public final NameParameter name;
	public final DescriptionParameter description;
	public final StartDateParameter date;
	public final LocationParameter location;
	public final TotalSeatsParameter seats;
	public final IdParameter id;
	
	public CourseCreationParameters(HttpServletRequest request) {
		name = new NameParameter(request);
		description = new DescriptionParameter(request);
		location = new LocationParameter(request);
		date = new StartDateParameter(request);
		seats = new TotalSeatsParameter(request);
		id = new IdParameter(request);
	}

	public CourseCreationParameters(Seminar s) {
		name = new NameParameter(s.getName());
		description = new DescriptionParameter(s.getDescription());
		location = new LocationParameter(s.getLocation());
		date = new StartDateParameter(s.getStartDateForSql());
		seats = new TotalSeatsParameter(String.valueOf(s.getSeatsLeft()));
		id = new IdParameter(s.getId());
	}

	public Seminar getSeminar() {
		return new Seminar(name.getValue(),
				id.getValue(),
				description.getValue(),
				date.getCalendarValue(),
				location.getValue(),
				seats.getIntegerValue()
		);
	}

	public List<InputParameter> getParameterList() {
		return Arrays.asList(id, name, description, location, date, seats);
	}

	public boolean isWholeInputValid() {
		return getParameterList().stream()
				.allMatch(param -> param.getValidationErrors().isEmpty());
	}
}

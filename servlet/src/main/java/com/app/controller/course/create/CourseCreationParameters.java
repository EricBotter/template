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
	private final List<InputParameter> _paramList;
	
	public CourseCreationParameters(HttpServletRequest request) {
		name = new NameParameter(request);
		description = new DescriptionParameter(request);
		location = new LocationParameter(request);
		date = new StartDateParameter(request);
		seats = new TotalSeatsParameter(request);
		_paramList = Arrays.asList(name, description, location, date, seats);
	}
	
	public Seminar getSeminar() {
		return new Seminar(name.getValue(),
				"0",
				description.getValue(),
				date.getCalendarValue(),
				location.getValue(),
				seats.getIntegerValue()
		);
	}

	public boolean isWholeInputValid() {
		return _paramList.stream().allMatch(param -> param.getValidationErrors().size() == 0);
	}
}

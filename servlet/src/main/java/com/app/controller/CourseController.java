package com.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import seminar.Course;
import seminar.Seminar;

public abstract class CourseController extends Controller {

	private static ArrayList<Seminar> _seminars = new ArrayList<>();
	
	protected List<Seminar> getSeminars() {
		return Collections.unmodifiableList(_seminars);
	}
	
	protected void addSeminar(
		String name,
		String number,
		String description,
		String startDate,
		String location,
		String seatsLeft
	) {
		String[] dateElements = startDate.split("-");
		GregorianCalendar date = new GregorianCalendar(
				Integer.parseInt(dateElements[0]),
				Integer.parseInt(dateElements[1]),
				Integer.parseInt(dateElements[2])
			);
		Course course = new Course(name, number, description, date);
		_seminars.add(new Seminar(course, location, Integer.parseInt(seatsLeft)));
	}
	
}

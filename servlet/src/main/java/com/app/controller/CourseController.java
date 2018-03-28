package com.app.controller;

import java.util.GregorianCalendar;

import seminar.Course;
import seminar.Seminar;

public abstract class CourseController extends Controller {

	private static Seminar _seminar = Seminar.defaultSeminar();
	
	protected Seminar getSeminar() {
		return _seminar;
	}
	
	protected void setSeminar(
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
		_seminar = new Seminar(course, location, Integer.parseInt(seatsLeft));
	}
	
}

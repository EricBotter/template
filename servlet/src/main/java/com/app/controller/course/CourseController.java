package com.app.controller.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.app.controller.Controller;

import seminar.Seminar;

public abstract class CourseController extends Controller {

	private static ArrayList<Seminar> _seminars = new ArrayList<>();
	
	protected List<Seminar> getSeminars() {
		return Collections.unmodifiableList(_seminars);
	}
	
	protected void addSeminar(Seminar s) {
		_seminars.add(s);
	}
	
}

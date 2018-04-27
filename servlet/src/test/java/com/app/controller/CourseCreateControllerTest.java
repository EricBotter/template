package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.course.SeminarEntity;

public class CourseCreateControllerTest {

	@Test
	public void handles() {
		assertTrue(new CreateController<>(new SeminarEntity()).handles("/course/create/"));
		assertTrue(new CreateController<>(new SeminarEntity()).handles("/course/create"));
	}

}

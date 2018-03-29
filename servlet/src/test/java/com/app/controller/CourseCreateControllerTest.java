package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseCreateControllerTest {

	@Test
	public void handles() {
		assertTrue(new CourseCreateController().handles("/course/create/"));
		assertTrue(new CourseCreateController().handles("/course/create"));
	}

}

package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseCreateControllerTest {

	@Test
	public void handles() {
		assertTrue(new CreateController().handles("/course/create/"));
		assertTrue(new CreateController().handles("/course/create"));
	}

}

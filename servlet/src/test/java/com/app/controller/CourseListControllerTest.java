package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseListControllerTest {

	@Test
	public void test() {
		assertTrue(new ListController().handles("/course/"));
		assertTrue(new ListController().handles("/course"));
	}

}

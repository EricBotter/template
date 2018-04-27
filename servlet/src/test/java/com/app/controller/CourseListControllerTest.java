package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.course.CourseListController;

public class CourseListControllerTest {

	@Test
	public void test() {
		assertTrue(new CourseListController().handles("/course/"));
		assertTrue(new CourseListController().handles("/course"));
	}

}

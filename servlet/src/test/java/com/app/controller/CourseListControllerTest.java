package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.course.SeminarEntity;

public class CourseListControllerTest {

	@Test
	public void test() {
		assertTrue(new ListController<>(new SeminarEntity()).handles("/course/"));
		assertTrue(new ListController<>(new SeminarEntity()).handles("/course"));
	}

}

package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseHtmlControllerTest {

	@Test
	public void test() {
		assertTrue(new CourseHtmlController().handles("/course/html"));
	}

}

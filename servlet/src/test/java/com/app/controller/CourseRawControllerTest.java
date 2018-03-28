package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseRawControllerTest {

	@Test
	public void test() {
		assertTrue(new CourseRawController().handles("/course/raw"));
	}

}

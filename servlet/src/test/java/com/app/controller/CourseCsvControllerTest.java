package com.app.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseCsvControllerTest {

	@Test
	public void handles() {
		assertTrue(new CourseCsvController().handles("/course/csv"));
	}

}

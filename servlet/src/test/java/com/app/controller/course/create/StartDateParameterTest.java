package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.Month;

import org.junit.Test;

import com.app.controller.parameters.StartDateParameter;

public class StartDateParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptyDate().getName(), is("date"));
		assertThat(nullDate().getName(), is("date"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(emptyDate().getValidationErrors().size(), is(1));
		assertThat(nullDate().getValidationErrors().size(), is(1));
		assertThat(defaultDate().getValidationErrors().size(), is(0));
		assertThat(malformedDate().getValidationErrors().size(), is(1));
	}

	@Test
	public void testGetCalendarValue() {
		assertThat(defaultDate().getCalendarValue().getDayOfMonth(), is(1));
		assertThat(defaultDate().getCalendarValue().getMonth(), is(Month.JANUARY));
		assertThat(defaultDate().getCalendarValue().getYear(), is(2018));
		
		try {
			nullDate().getCalendarValue();
			fail("Null date did not throw NullPointerException");
		} catch (NullPointerException e) {
		}

		try {
			emptyDate().getCalendarValue();
			fail("Empty date did not throw some sort of Exception");
		} catch (Exception e) {
		}

		try {
			malformedDate().getCalendarValue();
			fail("Malformed date did not throw some sort of Exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void testGetValue() {
		assertNull(nullDate().getValue());
		assertThat(emptyDate().getValue(), is(""));
		assertThat(defaultDate().getValue(), is("2018-01-01"));
	}
	
	private StartDateParameter malformedDate() {
		return new StartDateParameter("9y5x-5-456");
	}

	private StartDateParameter defaultDate() {
		return new StartDateParameter("2018-01-01");
	}

	private StartDateParameter nullDate() {
		return new StartDateParameter((String)null);
	}

	private StartDateParameter emptyDate() {
		return new StartDateParameter("");
	}
}

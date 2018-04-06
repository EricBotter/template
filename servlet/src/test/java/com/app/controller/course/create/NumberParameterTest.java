package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptyNumber().getName(), is("number"));
		assertThat(nullNumber().getName(), is("number"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(emptyNumber().getValidationErrors().size(), is(1));
		assertThat(nullNumber().getValidationErrors().size(), is(1));
		assertThat(defaultNumber().getValidationErrors().size(), is(0));
	}

	@Test
	public void testGetValue() {
		assertNull(nullNumber().getValue());
		assertThat(emptyNumber().getValue(), is(""));
		assertThat(defaultNumber().getValue(), is("101"));
	}

	private NumberParameter defaultNumber() {
		return new NumberParameter("101");
	}

	private NumberParameter nullNumber() {
		return new NumberParameter((String)null);
	}

	private NumberParameter emptyNumber() {
		return new NumberParameter("");
	}
}

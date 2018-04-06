package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NameParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptyName().getName(), is("name"));
		assertThat(nullName().getName(), is("name"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(emptyName().getValidationErrors().size(), is(1));
		assertThat(nullName().getValidationErrors().size(), is(1));
		assertThat(defaultName().getValidationErrors().size(), is(0));
		assertThat(longName().getValidationErrors().size(), is(1));
	}

	@Test
	public void testGetValue() {
		assertNull(nullName().getValue());
		assertThat(emptyName().getValue(), is(""));
		assertThat(defaultName().getValue(), is("Name"));
	}

	private NameParameter longName() {
		return new NameParameter("Name which is too long to be valid");
	}
	
	private NameParameter defaultName() {
		return new NameParameter("Name");
	}

	private NameParameter nullName() {
		return new NameParameter((String)null);
	}

	private NameParameter emptyName() {
		return new NameParameter("");
	}
}

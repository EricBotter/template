package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.parameters.DescriptionParameter;

public class DescriptionParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptyDescription().getName(), is("description"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(nullDescription().getValidationErrors().size(), is(0));
		assertThat(emptyDescription().getValidationErrors().size(), is(0));
		assertThat(defaultDescription().getValidationErrors().size(), is(0));
	}

	@Test
	public void testGetValue() {
		assertNotNull(nullDescription().getValue());
		assertThat(emptyDescription().getValue(), is(""));
		assertThat(defaultDescription().getValue(), is("Description"));
	}

	private DescriptionParameter defaultDescription() {
		return new DescriptionParameter("Description");
	}

	private DescriptionParameter nullDescription() {
		return new DescriptionParameter((String)null);
	}

	private DescriptionParameter emptyDescription() {
		return new DescriptionParameter("");
	}
}

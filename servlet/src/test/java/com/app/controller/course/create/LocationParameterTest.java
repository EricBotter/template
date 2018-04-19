package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.create.LocationParameter;

public class LocationParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptyLocation().getName(), is("location"));
		assertThat(nullLocation().getName(), is("location"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(emptyLocation().getValidationErrors().size(), is(1));
		assertThat(nullLocation().getValidationErrors().size(), is(1));
		assertThat(defaultLocation().getValidationErrors().size(), is(0));
		assertThat(longLocation().getValidationErrors().size(), is(1));
	}

	@Test
	public void testGetValue() {
		assertNull(nullLocation().getValue());
		assertThat(emptyLocation().getValue(), is(""));
		assertThat(defaultLocation().getValue(), is("Location"));
	}

	private LocationParameter longLocation() {
		return new LocationParameter("Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch");
	}
	
	private LocationParameter defaultLocation() {
		return new LocationParameter("Location");
	}

	private LocationParameter nullLocation() {
		return new LocationParameter((String)null);
	}

	private LocationParameter emptyLocation() {
		return new LocationParameter("");
	}
}

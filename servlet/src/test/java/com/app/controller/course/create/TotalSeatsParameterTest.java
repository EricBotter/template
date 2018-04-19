package com.app.controller.course.create;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.app.controller.create.TotalSeatsParameter;

public class TotalSeatsParameterTest {

	@Test
	public void testGetName() {
		assertThat(emptySeats().getName(), is("seats"));
		assertThat(nullSeats().getName(), is("seats"));
	}

	@Test
	public void testGetValidationErrors() {
		assertThat(nullSeats().getValidationErrors().size(), is(1));
		assertThat(emptySeats().getValidationErrors().size(), is(1));
		assertThat(defaultSeats().getValidationErrors().size(), is(0));
		assertThat(manySeats().getValidationErrors().size(), is(1));
		assertThat(longSeats().getValidationErrors().size(), is(2));
	}

	@Test
	public void testGetIntegerValue() {
		assertThat(defaultSeats().getIntegerValue(), is(50));
		assertThat(manySeats().getIntegerValue(), is(200));
		assertThat(longSeats().getIntegerValue(), is(10000));

		try {
			nullSeats().getIntegerValue();
			fail("Null seats did not throw some sort of Exception");
		} catch (Exception e) {
		}

		try {
			emptySeats().getIntegerValue();
			fail("Empty seats did not throw some sort of Exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void testGetValue() {
		assertNull(nullSeats().getValue());
		assertThat(emptySeats().getValue(), is(""));
		assertThat(defaultSeats().getValue(), is("50"));
	}

	
	private TotalSeatsParameter longSeats() {
		return new TotalSeatsParameter("10000");
	}
	
	private TotalSeatsParameter manySeats() {
		return new TotalSeatsParameter("200");
	}

	private TotalSeatsParameter defaultSeats() {
		return new TotalSeatsParameter("50");
	}

	private TotalSeatsParameter nullSeats() {
		return new TotalSeatsParameter((String)null);
	}

	private TotalSeatsParameter emptySeats() {
		return new TotalSeatsParameter("");
	}
}

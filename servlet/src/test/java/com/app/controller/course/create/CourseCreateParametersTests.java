package com.app.controller.course.create;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DescriptionParameterTest.class, LocationParameterTest.class, NameParameterTest.class,
		StartDateParameterTest.class, TotalSeatsParameterTest.class })
public class CourseCreateParametersTests {

}

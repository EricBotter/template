package seminar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SeminarTest {

	@Test
	public void enrolStudent() {
		Course course = Course.defaultCourse();
		Student s1 = new Student("Name", "Surname");
		Student s2 = new Student("Name2", "Surname2");
		Seminar seminar = new Seminar(course, "", 1);

		boolean enrolFirst = seminar.enrolStudent(s1);
		boolean enrolSecond = seminar.enrolStudent(s2);
		
		assertTrue(enrolFirst);
		assertFalse(enrolSecond);
		assertThat(seminar.getStudentList().size(), is(1));
		assertThat(seminar.getStudentList().get(0), is(s1));
	}

}

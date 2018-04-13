package seminar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class SeminarTest {

	@Test
	public void enrolStudent() {
		Seminar seminar = new Seminar("Test", "10", "Desc", new GregorianCalendar(), "", 1);
		Student s1 = new Student("Name", "Surname");
		Student s2 = new Student("Name2", "Surname2");

		boolean enrolFirst = seminar.enrolStudent(s1);
		boolean enrolSecond = seminar.enrolStudent(s2);
		
		assertTrue(enrolFirst);
		assertFalse(enrolSecond);
		assertThat(seminar.getStudentList().size(), is(1));
		assertThat(seminar.getStudentList().get(0), is(s1));
	}

}

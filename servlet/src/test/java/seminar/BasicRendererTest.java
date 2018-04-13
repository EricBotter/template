package seminar;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicRendererTest {

	@Test
	public void output() {
		Seminar seminar = Seminar.defaultSeminar();
		
		String output = new BasicRenderer().output(seminar);
		
		assertTrue(output.contains(seminar.getName()));
		assertTrue(output.contains(seminar.getLocation()));
		assertTrue(output.contains(seminar.getDescription()));
		assertTrue(output.contains(String.valueOf(seminar.getSeatsLeft())));
		if (!seminar.getStudentList().isEmpty()) {
			assertTrue(output.contains(seminar.getStudentList().get(0).getName()));
			assertTrue(output.contains(seminar.getStudentList().get(
					seminar.getStudentList().size() - 1
				).getName()));
		}
	}

}

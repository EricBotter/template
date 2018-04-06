package seminar;

public class BasicRenderer extends Renderer {

	@Override
	String getHeader(Seminar seminar) {
		return "Name: " + seminar.getName() + "\n"
    			+ "Description: " + seminar.getDescription() + "\n"
    			+ "Location: " + seminar.getLocation() + "\n"
    			+ "Start date: " + seminar.getCourse().getStartDateAsString() + "\n"
    			+ "Seats left: " + seminar.getSeatsLeft() + "\n"
    			+ "Enrolled students: ";
	}

	@Override
	String getFooter() {
		return "";
	}

	@Override
	String getStudentLine(Student student) {
		return student.getFullName() + ", ";
	}
}

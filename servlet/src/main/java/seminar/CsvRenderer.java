package seminar;

public class CsvRenderer extends Renderer {

	@Override
	String getHeader(Seminar seminar) {
		return String.join(";", new String[] {
    			seminar.getId(),
    			seminar.getName(),
    			seminar.getDescription(),
    			seminar.getLocation(),
    			seminar.getStartDateAsString(),
    			String.valueOf(seminar.getSeatsLeft())
    	}) + "\n";
	}

	@Override
	String getFooter() {
		return "";
	}

	@Override
	String getStudentLine(Student student) {
		return student.getName() + ";" + student.getSurname() + "\n";
	}
}

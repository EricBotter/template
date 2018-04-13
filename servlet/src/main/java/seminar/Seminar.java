package seminar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class Seminar {

	private final String _name;
	private final String _id;
	private final String _description;
	private final GregorianCalendar _startDate;
	private final List<Enrollment> _enrollments;

	private String _location;
	private int _seatsLeft;

	public Seminar(String name, String id, String description, GregorianCalendar startDate, String location, int seatsLeft) {
		_name = name;
		_id = id;
		_description = description;
		_startDate = startDate;
		_location = location;
		_seatsLeft = seatsLeft;
		_enrollments = new ArrayList<>();
	}

	public String getName() {
		return _name;
	}

	public String getId() {
		return _id;
	}

	public String getDescription() {
		return _description;
	}

	public String getStartDateAsString() {
		return _startDate.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ _startDate.get(GregorianCalendar.MONTH) + "/"
				+ _startDate.get(GregorianCalendar.YEAR);
	}
	
	public GregorianCalendar getStartDate() {
		return _startDate;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public int getSeatsLeft() {
		return _seatsLeft;
	}

	public void setSeatsLeft(int seatsLeft) {
		_seatsLeft = seatsLeft;
	}

	public List<Student> getStudentList() {
		return _enrollments.stream()
				.map(e -> {
					return e.getStudent();
				})
				.collect(Collectors.toList());
	}

    public boolean enrolStudent(Student student) {
    	if (_seatsLeft > 0) {
	        Enrollment enrollment = new Enrollment(student);
	        _enrollments.add(enrollment);
	        _seatsLeft--;
	        return true;
    	}
    	return false;
    }
    
    public static Seminar defaultSeminar() {
    	Student s1 = new Student("Eric", "Botter");
        Student s2 = new Student("Marco", "Verdi");

		Seminar seminar = new Seminar("Intro", "101", "Introduction Course",
				new GregorianCalendar(2018, 3, 8), "Room 3", 100);
        seminar.enrolStudent(s1);
        seminar.enrolStudent(s2);
        return seminar;
    }
}

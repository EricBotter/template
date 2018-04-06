package seminar;
import java.util.GregorianCalendar;

public class Course {

	private final String _name;
	private final String _number;
	private final String _description;
	private final GregorianCalendar _startDate;
	
	public Course(String name, String number, String description, GregorianCalendar startDate) {
		_name = name;
		_number = number;
		_description = description;
		_startDate = startDate;
	}

	public String getName() {
		return _name;
	}
	
	public String getNumber() {
		return _number;
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

	public static Course defaultCourse() {
		return new Course("Intro", "101", "Introduction Course",
					new GregorianCalendar(2018, 3, 8)
				);
	}
}

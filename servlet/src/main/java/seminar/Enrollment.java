package seminar;

public class Enrollment {

	private final Student _student;
	
	public Enrollment(Student student) {
		this._student = student;
	}

	public String getInfo() {
		return _student.getFullName();
	}

	public Student getStudent() {
		return _student;
	}
}

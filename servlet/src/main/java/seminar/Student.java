package seminar;

public class Student {

	private final String _name, _surname;
	private final int _id;

	public Student(String name, String surname) {
		this(0, name, surname);
	}
	
    public Student(int id, String name, String surname) {
        _name = name;
        _surname = surname;
        _id = id;
    }

	public String getName() {
		return _name;
	}

	public String getSurname() {
		return _surname;
	}
	
	public int getId() {
		return _id;
	}

	public String getFullName() {
		return _name + " " + _surname;
	}
}

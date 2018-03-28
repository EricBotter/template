package seminar;

public abstract class Renderer {
	public String output(Seminar seminar) {
    	String output = getHeader(seminar);
    	
    	for (Student student: seminar.getStudentList())
    		output += getStudentLine(student);

    	output += getFooter();

    	return output;
	}

	abstract String getHeader(Seminar seminar); 
	abstract String getStudentLine(Student student);
	abstract String getFooter();
}

package seminar;
import java.time.LocalDate;

public class SeminarDetails {

    private final Seminar _seminar;

    public SeminarDetails(Seminar seminar) {
        _seminar = seminar;
    }
    
	public static void main(String[] args) {
        Student s1 = new Student("Eric", "Botter");
        Student s2 = new Student("Marco", "Verdi");

		Seminar seminar = new Seminar("Intro", "101", "Introduction Course",
				LocalDate.of(2018, 3, 8), "Room 3", 100);
        seminar.enrolStudent(s1);
        seminar.enrolStudent(s2);

        SeminarDetails details = new SeminarDetails(seminar);
		
        new BasicRenderer().output(details._seminar);
        new HtmlRenderer().output(details._seminar);
        new CsvRenderer().output(details._seminar);
	}

}

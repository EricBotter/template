package seminar;

public class HtmlRenderer extends Renderer {

	@Override
	String getHeader(Seminar seminar) {
		return "<html>\n<head>\n\t<title>" + seminar.getName() + "</title>\n"
    			+ "</head>\n<body>\n"
    			+ "\t<div>" + seminar.getName() + ":</div>\n\t<ul>\n"
    			+ "\t\t<li>" + seminar.getDescription() + "</li>\n"
    			+ "\t\t<li>" + seminar.getLocation() + "</li>\n"
    			+ "\t\t<li>" + seminar.getCourse().getStartDate() + "</li>\n"
    			+ "\t\t<li>" + seminar.getSeatsLeft() + "</li>\n"
    			+ "\t</ul>\n\t<div>partecipanti:</div>\n\t<ul>\n";
	}

	@Override
	String getFooter() {
		return "\t</ul>\n</body>\n</html>";
	}

	@Override
	String getStudentLine(Student student) {
		return "\t\t<li>" + student.getFullName() + "</li>\n";
	}
}

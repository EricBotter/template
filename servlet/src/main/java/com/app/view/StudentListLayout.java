package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.List;
import java.util.stream.Collectors;

import seminar.Student;

public class StudentListLayout extends ListLayout<Student> {

	@Override
	protected String tableHeader() {
		return "       <thead>\n" + 
				"        <tr>\n" + 
				"         <th>name</th>\n" + 
				"         <th>surname</th>\n" + 
				"         <th colspan='2'>actions</th>\n" + 
				"        </tr>\n" + 
				"       </thead>\n";
	}

	@Override
	protected String tableBody(List<Student> students) {
		return students.stream().map(student ->
				tr(
					td(student.getName()),
					td(student.getSurname()),
					td(a(attr("href->/student/" + student.getId()), "edit")),
					td(a(attr("href->/student/delete/" + student.getId()), "delete"))
				).render()
			).collect(Collectors.joining("\n", "<tbody>", "</tbody>"));
	}
}

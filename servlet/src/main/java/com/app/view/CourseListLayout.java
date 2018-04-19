package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.List;
import java.util.stream.Collectors;

import seminar.Seminar;

public class CourseListLayout extends ListLayout<Seminar> {

	@Override
	protected String tableHeader() {
		return "       <thead>\n" + 
				"        <tr>\n" + 
				"         <th>name</th>\n" + 
				"         <th>location</th>\n" + 
				"         <th>totalSeats</th>\n" + 
				"         <th>start</th>\n" + 
				"         <th>actions</th>\n" + 
				"        </tr>\n" + 
				"       </thead>\n";
	}

	@Override
	protected String tableBody(List<Seminar> seminars) {
		return seminars.stream().map(seminar ->
				tr(
					td(a(attr("href -> /course/" + seminar.getId()),
						seminar.getName())),
					td(seminar.getLocation()),
					td(String.valueOf(seminar.getSeatsLeft())),
					td(seminar.getStartDateAsString()),
					td(a(attr("href->/course/delete/" + seminar.getId()), "delete"))
				).render()
			).collect(Collectors.joining("\n", "<tbody>", "</tbody>"));
	}
}

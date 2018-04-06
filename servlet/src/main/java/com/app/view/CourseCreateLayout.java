package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.app.controller.course.create.CourseCreationParameters;
import com.app.controller.course.create.InputError;
import com.app.controller.course.create.InputParameter;
import com.github.manliogit.javatags.element.Element;

public class CourseCreateLayout {

	public Element buildEmpty() {
		return compileForm(
			inputFieldEmpty("name", "text", "Name", "Introductory Seminar"),
			inputFieldEmpty("number", "text", "Number", "101"),
			inputFieldEmpty("description", "text", "Description", "Introduction to the Academy"),
			inputFieldEmpty("date", "date", "Start Date", "2018-03-21"),
			inputFieldEmpty("location", "text", "Location", "Room 3, main building"),
			inputFieldEmpty("seats", "number", "Tot. seats", "200")
		);
	}
	
	public Element build(CourseCreationParameters params) {
		return compileForm(
			inputFieldWithData(params.name, "text", "Name", "Introductory Seminar"),
			inputFieldWithData(params.number, "text", "Number", "101"),
			inputFieldWithData(params.description, "text", "Description", "Introduction to the Academy"),
			inputFieldWithData(params.date, "date", "Start Date", "2018-03-21"),
			inputFieldWithData(params.location, "text", "Location", "Room 3, main building"),
			inputFieldWithData(params.seats, "number", "Tot. seats", "200")
		);
	}

	private Element inputFieldEmpty(String fieldName, String inputType, String label, String placeholder) {
		return div(attr("class -> form-group"),
			label(attr("for -> "+fieldName, "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> "+inputType, "class -> form-control", "id -> "+fieldName, "name -> "+fieldName,
					"placeholder -> e.g. "+placeholder))
			)
		);
	}
	
	private Element inputFieldWithData(InputParameter param, String inputType, String label, String placeholder) {
		ArrayList<Element> divElements = new ArrayList<>(Arrays.asList(
			input(attr("type -> "+inputType, "class -> form-control", "id -> "+param.getName(), "name -> "+param.getName(),
				"placeholder -> e.g. "+placeholder, "value -> " + param.getValue())),
			param.getValidationErrors().isEmpty() ?
				span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
				span(attr("class -> glyphicon glyphicon-remove form-control-feedback"))
		));
		for (InputError e : param.getValidationErrors()) {
			divElements.add(span(attr("class -> help-block"), e.getMessage()));
		}

		return div(attr("class -> form-group " + (param.getValidationErrors().isEmpty() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> "+param.getName(), "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"), divElements)
		);
	}
	
	private Element compileForm(Element... formElements) {
		ArrayList<Element> elements = new ArrayList<>(Arrays.asList(formElements));
		elements.add(
				div(attr("class -> form-group"),
					div(attr("class -> col-sm-10 col-sm-offset-2"),
						input(attr("id -> submit", "name -> submit", "type -> submit",
							"value -> Send", "class -> btn btn-primary"))
					)
				)
			);
		return html5(
			head(
				meta(attr("charset -> utf-8")),
				meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
				meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
				title("Seminar"),
				link(attr("href -> /css/bootstrap.min.css", "rel -> stylesheet"))
			), body(
				div(attr("class -> container"),
					div(attr("class -> row"),
						div(attr("class -> col-md-6 col-md-offset-3"),
							h1(attr("class -> page-header text-center"), "Create Course"),
							form(attr("class -> form-horizontal", "method -> POST"),
								elements
							)
						)
					)
				),
				script(attr("src -> /js/jquery.min.js")),
				script(attr("src -> /js/bootstrap.min.js"))
			)
		);
	}
}

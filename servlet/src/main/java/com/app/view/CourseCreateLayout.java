package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.app.controller.course.create.CourseCreationParameters;
import com.app.controller.course.create.InputParameter;
import com.app.controller.course.create.StartDateParameter;
import com.github.manliogit.javatags.element.Element;

public class CourseCreateLayout {

	public Element buildEmpty() {
		return compileForm(
			textField("name", "Name", "Introductory Seminar"),
			textField("number", "Number", "101"),
			textField("description", "Description", "Introduction to the Academy"),
			startDateField(),
			textField("location", "Location", "Room 3, main building"),
			numberField("seats", "Tot. seats", "200")
		);
	}
	
	public Element build(CourseCreationParameters params) {
		return compileForm(
			textField(params.name, "Name", "Introductory Seminar", "Please enter a valid name"),
			textField(params.number, "Number", "101", "Please enter a valid number (check total seats first)"),
			textField(params.description, "Description", "Introduction to the Academy", "Please enter a valid description"),
			startDateField(params.date),
			textField(params.location, "Location", "Room 3, main building", "Please enter a valid location"),
			numberField(params.seats, "Tot. seats", "200", "Please enter a valid number of seats")
		);
	}

	private Element startDateField(StartDateParameter date) {
		return div(attr("class -> form-group " + (date.isValid() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> date", "class -> col-sm-2 control-label"), "Start date"),
			div(attr("class -> col-sm-10"),
				input(attr("type -> date", "class -> form-control", "id -> date", "name -> date",
					"value -> " + date.getValue())),
				date.isValid() ?
						span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
						span(attr("class -> glyphicon glyphicon-remove form-control-feedback")),
				date.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid date")
			)
		);
	}

	private Element startDateField() {
		return div(attr("class -> form-group"),
				label(attr("for -> date", "class -> col-sm-2 control-label"), "Start date"),
				div(attr("class -> col-sm-10"),
						input(attr("type -> date", "class -> form-control", "id -> date", "name -> date"))
				)
			);
	}
	
	private Element textField(InputParameter param, String label, String placeholder, String errorMessage) {
		return div(attr("class -> form-group " + (param.isValid() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> "+param.getName(), "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> text", "class -> form-control", "id -> "+param.getName(), "name -> "+param.getName(),
					"placeholder -> e.g. "+placeholder, "value -> " + param.getValue())),
				param.isValid() ?
						span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
						span(attr("class -> glyphicon glyphicon-remove form-control-feedback")),
				param.isValid() ? empty() : span(attr("class -> help-block"), errorMessage)
			)
		);
	}

	private Element textField(String fieldName, String label, String placeholder) {
		return div(attr("class -> form-group"),
			label(attr("for -> "+fieldName, "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> text", "class -> form-control", "id -> "+fieldName, "name -> "+fieldName,
					"placeholder -> e.g. "+placeholder))
			)
		);
	}

	private Element numberField(InputParameter param, String label, String placeholder, String errorMessage) {
		return div(attr("class -> form-group " + (param.isValid() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> "+param.getName(), "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> number", "class -> form-control", "id -> "+param.getName(), "name -> "+param.getName(),
					"placeholder -> e.g. "+placeholder, "value -> " + param.getValue())),
				param.isValid() ?
						span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
						span(attr("class -> glyphicon glyphicon-remove form-control-feedback")),
				param.isValid() ? empty() : span(attr("class -> help-block"), errorMessage)
			)
		);
	}
	
	private Element numberField(String fieldName, String label, String placeholder) {
		return div(attr("class -> form-group"),
			label(attr("for -> "+fieldName, "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> number", "class -> form-control", "id -> "+fieldName, "name -> "+fieldName,
					"placeholder -> e.g. "+placeholder))
			)
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

	private Element empty() {
		return new Element() {
			@Override
			public String render() {
				return "";
			}
		};
	}
}

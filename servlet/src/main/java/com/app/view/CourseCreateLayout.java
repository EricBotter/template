package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.app.controller.course.create.CourseCreationParameters;
import com.app.controller.course.create.InputError;
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
			textField(params.name, "Name", "Introductory Seminar"),
			textField(params.number, "Number", "101"),
			textField(params.description, "Description", "Introduction to the Academy"),
			startDateField(params.date),
			textField(params.location, "Location", "Room 3, main building"),
			numberField(params.seats, "Tot. seats", "200")
		);
	}

	private Element startDateField(StartDateParameter date) {
		ArrayList<Element> divElements = new ArrayList<>(Arrays.asList(
				input(attr("type -> date", "class -> form-control", "id -> date", "name -> date",
					"value -> " + date.getValue())),
				date.validate().isEmpty() ?
					span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
					span(attr("class -> glyphicon glyphicon-remove form-control-feedback"))
				));
		for (InputError e : date.validate()) {
			divElements.add(span(attr("class -> help-block"), e.getMessage()));
		}

		return div(attr("class -> form-group " + (date.validate().isEmpty() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> date", "class -> col-sm-2 control-label"), "Start date"),
			div(attr("class -> col-sm-10"), divElements)
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
	
	private Element textField(InputParameter param, String label, String placeholder) {
		ArrayList<Element> divElements = new ArrayList<>(Arrays.asList(
				input(attr("type -> text", "class -> form-control", "id -> "+param.getName(), "name -> "+param.getName(),
					"placeholder -> e.g. "+placeholder, "value -> " + param.getValue())),
				param.validate().isEmpty() ?
					span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
					span(attr("class -> glyphicon glyphicon-remove form-control-feedback"))
		));
		for (InputError e : param.validate()) {
			divElements.add(span(attr("class -> help-block"), e.getMessage()));
		}

		return div(attr("class -> form-group " + (param.validate().isEmpty() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> "+param.getName(), "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"), divElements)
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

	private Element numberField(InputParameter param, String label, String placeholder) {
		ArrayList<Element> divElements = new ArrayList<>(Arrays.asList(
			input(attr("type -> number", "class -> form-control", "id -> "+param.getName(), "name -> "+param.getName(),
				"placeholder -> e.g. "+placeholder, "value -> " + param.getValue())),
			param.validate().isEmpty() ?
				span(attr("class -> glyphicon glyphicon-ok form-control-feedback")) :
				span(attr("class -> glyphicon glyphicon-remove form-control-feedback"))
		));
		for (InputError e : param.validate()) {
			divElements.add(span(attr("class -> help-block"), e.getMessage()));
		}
		
		return div(attr("class -> form-group " + (param.validate().isEmpty() ? "has-success" : "has-error") + " has-feedback"),
			label(attr("for -> "+param.getName(), "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"), divElements)
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
}

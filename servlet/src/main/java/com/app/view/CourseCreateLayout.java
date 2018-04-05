package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.app.controller.course.create.CourseCreationParameters;
import com.github.manliogit.javatags.element.Element;

public class CourseCreateLayout {

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
	
	public Element buildEmpty() {
		return compileForm(
			div(attr("class -> form-group"),
				label(attr("for -> name", "class -> col-sm-2 control-label"), "Name"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> name", "name -> name",
						"placeholder -> e.g. Introductory Seminar"))
				)
			),
			div(attr("class -> form-group"),
				label(attr("for -> number", "class -> col-sm-2 control-label"), "Number"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> number", "name -> number",
						"placeholder -> e.g. 101"))
				)
			),
			div(attr("class -> form-group"),
				label(attr("for -> description", "class -> col-sm-2 control-label"), "Description"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> description", "name -> description",
						"placeholder -> e.g. Introduction to the Academy"))
				)
			),
			div(attr("class -> form-group"),
				label(attr("for -> date", "class -> col-sm-2 control-label"), "Start date"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> date", "class -> form-control", "id -> date", "name -> date"))
				)
			),
			div(attr("class -> form-group"),
				label(attr("for -> location", "class -> col-sm-2 control-label"), "Location"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> location", "name -> location",
						"placeholder -> e.g. Room 3, main building"))
				)
			),
			div(attr("class -> form-group"),
				label(attr("for -> seats", "class -> col-sm-2 control-label"), "Tot. seats"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> number", "class -> form-control", "id -> seats", "name -> seats",
						"placeholder -> e.g. 200"))
				)
			)
		);
	}
	
	
	public Element build(CourseCreationParameters params) {
		return compileForm(
			div(attr("class -> form-group " + (params.name.isValid() ? "has-success" : "has-error")),
				label(attr("for -> name", "class -> col-sm-2 control-label"), "Name"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> name", "name -> name",
						"placeholder -> e.g. Introductory Seminar", "value -> " + params.name.getValue())),
					(params.name.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid name"))
				)
			),
			div(attr("class -> form-group " + (params.number.isValid() ? "has-success" : "has-error")),
				label(attr("for -> number", "class -> col-sm-2 control-label"), "Number"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> number", "name -> number",
						"placeholder -> e.g. 101", "value -> " + params.number.getValue())),
					(params.number.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid number"))
				)
			),
			div(attr("class -> form-group " + (params.description.isValid() ? "has-success" : "has-error")),
				label(attr("for -> description", "class -> col-sm-2 control-label"), "Description"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> description", "name -> description",
						"placeholder -> e.g. Introduction to the Academy", "value -> " + params.description.getValue())),
					(params.description.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid description"))
				)
			),
			div(attr("class -> form-group " + (params.date.isValid() ? "has-success" : "has-error")),
				label(attr("for -> date", "class -> col-sm-2 control-label"), "Start date"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> date", "class -> form-control", "id -> date", "name -> date",
							"value -> " + params.date.getValue())),
					(params.date.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid date"))
				)
			),
			div(attr("class -> form-group " + (params.location.isValid() ? "has-success" : "has-error")),
				label(attr("for -> location", "class -> col-sm-2 control-label"), "Location"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> text", "class -> form-control", "id -> location", "name -> location",
						"placeholder -> e.g. Room 3, main building", "value -> " + params.location.getValue())),
					(params.location.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid location"))
				)
			),
			div(attr("class -> form-group " + (params.seats.isValid() ? "has-success" : "has-error")),
				label(attr("for -> seats", "class -> col-sm-2 control-label"), "Tot. seats"),
				div(attr("class -> col-sm-10"),
					input(attr("type -> number", "class -> form-control", "id -> seats", "name -> seats",
						"placeholder -> e.g. 200", "value -> " + params.seats.getValue())),
					(params.seats.isValid() ? empty() : span(attr("class -> help-block"), "Please enter a valid number of seats"))
				)
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

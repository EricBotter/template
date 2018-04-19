package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.app.controller.create.IdParameter;
import com.app.controller.create.InputError;
import com.app.controller.create.InputParameter;
import com.app.controller.create.InputParametersForItem;
import com.github.manliogit.javatags.element.Element;

public abstract class FormLayout<T> {

	protected Element inputFieldEmpty(String fieldName, String inputType, String label, String placeholder) {
		return div(attr("class -> form-group"),
			label(attr("for -> "+fieldName, "class -> col-sm-2 control-label"), label),
			div(attr("class -> col-sm-10"),
				input(attr("type -> "+inputType, "class -> form-control", "id -> "+fieldName, "name -> "+fieldName,
					"placeholder -> e.g. "+placeholder))
			)
		);
	}

	protected Element inputFieldWithData(InputParameter param, String inputType, String label, String placeholder) {
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

	protected Element hiddenIdInput() {
		return hiddenIdInput(new IdParameter("0"));
	}

	protected Element hiddenIdInput(IdParameter param) {
		return input(attr("type -> hidden", "class -> form-control", "id -> id", "name -> id",
				"value -> " + param.getValue()));
	}

	protected Element compileForm(Element... formElements) {
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

	public abstract Element build(InputParametersForItem<T> params);

	public abstract Element buildEmpty();

}

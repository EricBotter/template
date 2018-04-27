package com.app.controller;

import com.app.view.FormLayout;

public interface Creatable<T> extends NamedEntity<T>, EntityWithParameters<T>, DbSerializable<T> {

	FormLayout<T> getFormLayout();

}
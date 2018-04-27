package com.app.controller;

import com.app.view.FormLayout;

public interface Creatable<T> extends EntityWithInputParameters<T>, DbSerializable<T> {

	FormLayout<T> getFormLayout();

}
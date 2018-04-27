package com.app.controller;

import com.app.view.ListLayout;

public interface Listable<T> extends NamedEntity<T>, EntityWithParameters<T>, DbSerializable<T> {

	ListLayout<T> getListLayout();

}
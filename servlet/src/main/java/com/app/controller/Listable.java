package com.app.controller;

import com.app.view.ListLayout;

public interface Listable<T> extends EntityWithInputParameters<T>, DbSerializable<T> {

	ListLayout<T> getListLayout();

}
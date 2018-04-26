package com.app.controller;

import com.app.controller.parameters.InputParametersForItem;
import com.app.db.Mapper;
import com.app.view.FormLayout;
import com.app.view.ListLayout;

public interface EntityCollector<T> {
	String getName();
	Mapper<T> getMapper(Context context);
	FormLayout<T> getFormLayout();
	ListLayout<T> getListLayout();
	InputParametersForItem<T> getParameters(Context context);
	InputParametersForItem<T> getParameters(T item);
}

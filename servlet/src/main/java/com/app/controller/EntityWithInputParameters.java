package com.app.controller;

import com.app.controller.parameters.InputParametersForItem;

public interface EntityWithInputParameters<T> {

	InputParametersForItem<T> getParameters(Context context);

	InputParametersForItem<T> getParameters(T item);

}
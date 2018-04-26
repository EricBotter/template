package com.app.controller.parameters;

public interface InputParametersForItem<T> {
	T getItem();
	boolean isWholeInputValid();
}

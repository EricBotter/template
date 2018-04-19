package com.app.controller.create;

public interface InputParametersForItem<T> {
	T getItem();
	boolean isWholeInputValid();
}

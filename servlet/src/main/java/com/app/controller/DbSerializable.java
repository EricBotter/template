package com.app.controller;

import com.app.db.Mapper;

public interface DbSerializable<T> extends NamedEntity<T> {

	Mapper<T> getMapper(Context context);

}
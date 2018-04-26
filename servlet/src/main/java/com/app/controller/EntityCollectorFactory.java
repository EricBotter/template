package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.course.SeminarCollector;
import com.app.controller.student.StudentCollector;

public class EntityCollectorFactory {
	private static List<EntityCollector> _collectors = new ArrayList<EntityCollector>() {{
		add(new SeminarCollector()); add(new StudentCollector());
	}};
	
	public static EntityCollector getCollectorFromPath(String path) {
		for (EntityCollector collector : _collectors) {
			if (path.contains(collector.getName()))
				return collector;
		}
		return null;
	}
}

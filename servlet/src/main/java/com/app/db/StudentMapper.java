package com.app.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import seminar.Student;

public class StudentMapper extends Mapper<Student> {

	public StudentMapper(Connection connection) {
		super(connection);
	}

	@Override
	protected String insertQuery() {
		return "INSERT INTO Student(name, surname) VALUES(?, ?)";
	}

	@Override
	protected void compileInsertQuery(Student item, PreparedStatement ps) throws SQLException {
		ps.setString(1, item.getName());
		ps.setString(2, item.getSurname());
	}

	@Override
	protected String updateQuery() {
		return "UPDATE Student SET name = ?, surname = ? WHERE id = ?";
	}

	@Override
	protected void compileUpdateQuery(Student item, PreparedStatement ps) throws SQLException {
		compileInsertQuery(item, ps);
		ps.setInt(3, item.getId());
	}

	@Override
	protected String selectQuery() {
		return "SELECT id, name, surname FROM Student";
	}

	@Override
	protected Student itemFromSelectResult(ResultSet rs) throws SQLException {
		return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	@Override
	protected String deleteQuery() {
		return "DELETE FROM Student";
	}

}

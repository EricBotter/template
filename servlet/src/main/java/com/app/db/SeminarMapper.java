package com.app.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import seminar.Seminar;

public class SeminarMapper extends Mapper<Seminar> {

	public SeminarMapper(Connection connection) {
		super(connection);
	}

	@Override
	protected String insertQuery() {
		return "INSERT INTO Course(name, description, location, totalSeats, start) VALUES (?, ?, ?, ?, ?)";
	}

	@Override
	protected void compileInsertQuery(Seminar s, PreparedStatement ps) throws SQLException {
		ps.setString(1, s.getName());
		ps.setString(2, s.getDescription());
		ps.setString(3, s.getLocation());
		ps.setInt(4, s.getSeatsLeft());
		ps.setDate(5, Date.valueOf(s.getStartDate()));
	}

	@Override
	protected String updateQuery() {
		return "UPDATE Course SET name = ?, description = ?, location = ?,"
				+ "totalSeats = ?, start = ? WHERE id = ?";
	}

	@Override
	protected void compileUpdateQuery(Seminar s, PreparedStatement ps) throws SQLException {
		compileInsertQuery(s, ps);
		ps.setInt(6, Integer.valueOf(s.getId()));
	}

	@Override
	protected String selectQuery() {
		return "SELECT id, name, description, location, totalSeats, start FROM Course";
	}

	@Override
	protected Seminar itemFromSelectResult(ResultSet rs) throws SQLException {
		return new Seminar(
				rs.getString(2),
				String.valueOf(rs.getInt(1)),
				rs.getString(3),
				rs.getDate(6).toLocalDate(),
				rs.getString(4),
				rs.getInt(5)
		);
	}

	@Override
	protected String deleteQuery() {
		return "DELETE FROM Course";
	}

}

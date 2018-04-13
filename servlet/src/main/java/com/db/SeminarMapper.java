package com.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import seminar.Seminar;

public class SeminarMapper {

	private final Connection _connection;
	
	public SeminarMapper(Connection connection) {
		_connection = connection;
	}
	
	public void addSeminar(Seminar s) {
		try {
			PreparedStatement ps = _connection.prepareStatement(
					"INSERT INTO Course(name, description, location, totalSeats, start) "
					+ "VALUES (?, ?, ?, ?, ?)"
				);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDescription());
			ps.setString(3, s.getLocation());
			ps.setInt(4, s.getSeatsLeft());
			ps.setDate(5, new Date(s.getStartDate().getTimeInMillis()));
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Seminar> getSeminars() {
		ArrayList<Seminar> output = new ArrayList<>();
		try {
			PreparedStatement ps = _connection.prepareStatement(
					"SELECT id, name, description, location, totalSeats, start FROM Course"
				);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(rs.getDate(6));
				output.add(new Seminar(
						rs.getString(2),
						String.valueOf(rs.getInt(1)),
						rs.getString(3),
						gc,
						rs.getString(4),
						rs.getInt(5)
				));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Collections.unmodifiableList(output);
	}
}

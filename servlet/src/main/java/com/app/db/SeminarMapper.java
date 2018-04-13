package com.app.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
			ps.setDate(5, Date.valueOf(s.getStartDate()));
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateSeminar(Seminar s) {
		try {
			PreparedStatement ps = _connection.prepareStatement(
					"UPDATE Course SET name = ?, description = ?, location = ?,"
							+ "totalSeats = ?, start = ? WHERE id = ?"
					);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDescription());
			ps.setString(3, s.getLocation());
			ps.setInt(4, s.getSeatsLeft());
			ps.setDate(5, Date.valueOf(s.getStartDate()));
			ps.setInt(6, Integer.valueOf(s.getId()));
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
				output.add(new Seminar(
						rs.getString(2),
						String.valueOf(rs.getInt(1)),
						rs.getString(3),
						rs.getDate(6).toLocalDate(),
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

	public Seminar getSeminar(String id) {
		Seminar output = null;
		try {
			PreparedStatement ps = _connection.prepareStatement(
					"SELECT id, name, description, location, totalSeats, start FROM Course "
					+ "WHERE id = ?"
				);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				output = new Seminar(
						rs.getString(2),
						String.valueOf(rs.getInt(1)),
						rs.getString(3),
						rs.getDate(6).toLocalDate(),
						rs.getString(4),
						rs.getInt(5)
				);
			} else {
				System.out.println("No results!!!");
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return output;
	}
	
	public boolean deleteSeminar(String id) {
		boolean output = false;
		try {
			PreparedStatement ps = _connection.prepareStatement(
					"DELETE FROM Course WHERE id = ?"
					);
			ps.setString(1, id);
			output = ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return output;
	}
}

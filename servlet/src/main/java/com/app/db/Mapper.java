package com.app.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Mapper<T> {
	
	protected final Connection _connection;

	protected Mapper(Connection connection) {
		_connection = connection;
	}

	protected abstract String insertQuery();
	protected abstract void compileInsertQuery(T item, PreparedStatement ps) throws SQLException;

	public void addItem(T item) {
		try {
			PreparedStatement ps = _connection.prepareStatement(
					insertQuery()
				);
			compileInsertQuery(item, ps);
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract String updateQuery();
	protected abstract void compileUpdateQuery(T item, PreparedStatement ps) throws SQLException;

	public void updateItem(T item) {
		try {
			PreparedStatement ps = _connection.prepareStatement(
					updateQuery()
					);
			compileUpdateQuery(item, ps);
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected abstract String selectQuery();
	protected abstract T itemFromSelectResult(ResultSet rs) throws SQLException;

	public List<T> getAllItems() {
		ArrayList<T> output = new ArrayList<>();
		try {
			PreparedStatement ps = _connection.prepareStatement(
					selectQuery()
				);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				output.add(itemFromSelectResult(rs));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Collections.unmodifiableList(output);
	}
	
	public T getItemById(String id) {
		T output = null;
		try {
			PreparedStatement ps = _connection.prepareStatement(
					selectQuery() + " WHERE id = ?"
				);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				output = itemFromSelectResult(rs);
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

	protected abstract String deleteQuery();
	
	public boolean deleteItemById(String id) {
		boolean output = false;
		try {
			PreparedStatement ps = _connection.prepareStatement(
					deleteQuery()+" WHERE id = ?"
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

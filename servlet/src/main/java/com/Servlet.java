package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.controller.MainController;
import com.zaxxer.hikari.HikariDataSource;

public class Servlet extends HttpServlet {

	
//	private SQLiteConnectionPoolDataSource _ds;
//	_ds = new SQLiteConnectionPoolDataSource();
//	_ds.setUrl("jdbc:sqlite:/path");
	
//	private HikariDataSource _ds;
//  _ds = new HikariDataSource();
//	_ds.setJdbcUrl("jdbc:sqlite:/path");
	
	private DataSource _ds;
	
	@Override
	public void init() throws ServletException {
		try {
			_ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(Controller c : Arrays.asList(new MainController())){
			if(c.handles(req.getRequestURI())){
				try {
					Connection connection = _ds.getConnection();
					connection.setAutoCommit(false);
					c.execute(new Context(req, resp, connection));
					connection.commit();
					connection.close();
					return;
				} catch (Exception e) {
					resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					throw new RuntimeException(e);
				}
			}
		}
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
}

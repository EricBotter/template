package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import com.zaxxer.hikari.HikariDataSource;

public class Servlet extends HttpServlet {

	
//	private SQLiteConnectionPoolDataSource _ds;
//	_ds = new SQLiteConnectionPoolDataSource();
//	_ds.setUrl("jdbc:sqlite:/home/manlio/Linguaggi/template/servlet6/src/main/db/test.db");
	
//	private HikariDataSource _ds;
//  _ds = new HikariDataSource();
//	_ds.setJdbcUrl("jdbc:sqlite:/home/manlio/Linguaggi/template/servlet6/src/main/db/test.db");
	
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
		
		Connection connection = null;
		try {
			connection = _ds.getConnection();
			String sql = "CREATE TABLE IF NOT EXISTS hikariiiifromxmlXXX (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text NOT NULL,\n"
	                + "	capacity real\n"
	                + ");";
			
			connection.createStatement().execute(sql);
			
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(req.getRequestURI().equals("/try/me")){
			resp.getWriter().write("<h1>you did it!</h1>");
		}
		
		if(req.getRequestURI().equals("/try/bootstrap")){
			resp.getWriter().write(
			    "<!DOCTYPE html>                                                                                                                                 " +
			    "<html lang='en'>                                                                                                                                " +
			    "  <head>                                                                                                                                        " +
			    "    <meta charset='utf-8'>                                                                                                                      " +
			    "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
			    "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
			    "    <title>Seminar</title>                                                                                      								 " +
			    "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
			    "  </head>                                                                                                                                       " +
			    "  <body>                                                                                                                                        " +
			    "  	<div class='container'>                                                                                                                      " +
			    "  		<div class='row'>                                                                                                                        " +
			    "  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
			    "  				<h1 class='page-header text-center'>Contact Form Example</h1>                                                                    " +
			    "				<form class='form-horizontal' role='form' method='post' action=''>                                                      		 " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Name</label>                                                            " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='name' name='name' placeholder='First & Last Name' value='Name'>          " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='email' class='col-sm-2 control-label'>Email</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
		        "							<input type='email' class='form-control' id='email' name='email' placeholder='example@domain.com' value='Mail'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
			    "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "				</form>                                                                                                                          " +
			    "			</div>                                                                                                                               " +
			    "		</div>                                                                                                                                   " +
			    "	</div>                                                                                                                                       " +
			    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
			    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
			    "</body> "
		    );
		}
	}
}

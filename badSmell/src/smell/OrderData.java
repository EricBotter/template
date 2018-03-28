package smell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderData {

	public void saveOrder(Order order) throws SQLException {
		// create connection
		Connection conn = null;

		java.sql.Date date = new java.sql.Date((new java.util.Date())
				.getTime());
		PreparedStatement orderStatement = null;
		PreparedStatement getStatement = null;
		String sql = null;
		sql = new StringBuffer().append("INSERT INTO T_ORDER ")
				.append("(AUTHORIZATION_CODE, ")
				.append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) ")
				.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();
		conn = setConnection();
		orderStatement = conn.prepareStatement(sql);
		// set all parameters
		order.getTotal(); // etc.

		// execute statement
		orderStatement.executeUpdate();
	}
	
	private Connection setConnection() {
		return null;
	}
}

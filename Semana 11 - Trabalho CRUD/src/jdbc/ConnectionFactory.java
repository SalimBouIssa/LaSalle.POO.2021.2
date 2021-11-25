package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://database-1.csri4s17kvyq.us-east-1.rds.amazonaws.com:3306/bancoprog?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "admin";
	private static final String SENHA = "password";

	public static Connection getConnection() throws ClassNotFoundException {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
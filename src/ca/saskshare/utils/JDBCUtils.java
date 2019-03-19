package ca.saskshare.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:8889/saskshare";
	private static String user = "root";
	private static String password = "root123";

	private JDBCUtils() {

	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void free(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			} finally {

				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException exception2) {
						exception2.printStackTrace();
					}
				}

			}
		}
	}
}

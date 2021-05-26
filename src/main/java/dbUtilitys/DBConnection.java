package dbUtilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DB_NAME = "user.db";
	public static final String PATH = "/home/david/source/sqlite_dbs/";
	
	public static final String CONNECTION_STRING = "jdbc:sqlite:" + PATH + DB_NAME;
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(CONNECTION_STRING);
		return connection;
	}
}

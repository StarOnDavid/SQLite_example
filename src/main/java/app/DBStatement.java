package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtilitys.DBConnection;

public class DBStatement {
	
	// DB 
	private DBConnection dbConnection = new DBConnection();
	
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public boolean checkDBConnettion() throws SQLException {
		connection = dbConnection.getConnection();
		
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}
}

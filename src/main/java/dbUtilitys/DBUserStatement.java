package dbUtilitys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import app.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtilitys.DBConnection;

public class DBUserStatement {
	
	// DB members
	private DBConnection dbConnection = new DBConnection();
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// constants for table name and column names
	private final String TABLE_USER = "User";
	private final String COLUMN_ID = "id";
	private final String COLUMN_NAME = "name";
	private final String COLUMN_SURNAME = "surname";
	private final String COLUMN_MAIL = "mail";
	private final String COLUMN_CONTRY = "country";
	private final String COLUMN_REG_DATE = "reg_dateTime";
	
	
	/**
	 * check if the DB connection work correctly
	 * @return
	 * @throws SQLException
	 */
	public boolean checkDBConnettion() throws SQLException {
		connection = dbConnection.getConnection();
		
		if (connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/**
	 * create table
	 * @throws SQLException
	 */
	public void createUserTable() throws SQLException {
		String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + 
				" ( " +
				COLUMN_ID + " INTEGER PRIMARY KEY, " +
				COLUMN_NAME + " TEXT NOT NULL, " +
				COLUMN_SURNAME + " TEXT NOT NULL, " +
				COLUMN_MAIL + " TEXT NOT NULL UNIQUE, " +
				COLUMN_CONTRY + " TEXT NOT NULL, " +
				COLUMN_REG_DATE + " TEXT NOT NULL" +
				")";
		
		executeSQL(createTable);
	}
	
	/**
	 * insert one user into table 
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException {
		String insertUser = "INSERT INTO " + TABLE_USER + " VALUES " + insertUserSQLString(user);
		executeSQL(insertUser);
	}

	
	
	/**
	 * insert a list of users into table 
	 * @throws SQLException
	 */
	public void insertUsers(List<User> users) throws SQLException {
		StringBuilder insertUsers = new StringBuilder();
		insertUsers.append("INSERT INTO " + TABLE_USER + " VALUES  ");
		for (User user : users) {
			insertUsers.append(insertUserSQLString(user) + ", ");
		}
		insertUsers.delete(insertUsers.length() -2, insertUsers.length());
		
		executeSQL(insertUsers.toString());
	}
	
	
	/**
	 * get user with the id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User getUser(int id) throws SQLException {
		String getUser = "SELECT * FROM " + TABLE_USER + " WHERE id = " + id;

		List<User> result = executeSQLQuery(getUser);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	/**
	 * get a list with all users
	 * @return
	 * @throws SQLException
	 */
	public List<User> getAllUsers() throws SQLException {
		String getUsers = "SELECT * FROM " + TABLE_USER;
		return executeSQLQuery(getUsers); 
		
 	}


	public void deleteUser(int id) throws SQLException {
		String deleteQuery = "DELETE FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = " + id;
		executeSQL(deleteQuery);
	}

	
	
	
	// ---------- private methodes -------------------------------
	
	/**
	 * execute SQL
	 * @throws SQLException 
	 */
	private void executeSQL(String sqlQuery) throws SQLException {
		try {
			connection = dbConnection.getConnection();
			statement = connection.createStatement();
			if (statement != null) {
				statement.execute(sqlQuery);
			}
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	
	/**
	 * 
	 * @param getUsers
	 * @return
	 * @throws SQLException
	 */
	private List<User> executeSQLQuery(String sqlQuery) throws SQLException {
		List<User> users = new ArrayList();
		try {
			connection = dbConnection.getConnection();
			statement = connection.createStatement();
			if (statement != null) {
				resultSet = statement.executeQuery(sqlQuery);
				while(resultSet.next()) {
					users.add(dbResultToUser());
				}
			}
		} finally {
			statement.close();
			connection.close();
		}
		return users;
	}
	
	private String insertUserSQLString(User user) {
		String insertUser = 
				"(NULL, " + 
				"'" + user.getName() + "'," +
				"'" + user.getSurname() + "'," +
				"'" + user.getMail() + "'," +
				"'" + user.getCountry() + "'," +
				"'" + user.getReg_dateTime().toString() + "')";
		return insertUser;
	}
	
	private User dbResultToUser() throws SQLException {
		User user;
		user = new User (
				resultSet.getInt(COLUMN_ID),
				resultSet.getString(COLUMN_NAME),
				resultSet.getString(COLUMN_SURNAME),
				resultSet.getString(COLUMN_MAIL),
				resultSet.getString(COLUMN_CONTRY),
				LocalDateTime.parse(resultSet.getString(COLUMN_REG_DATE), DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSS"))
				);
		return user;
	}
}

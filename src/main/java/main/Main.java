package main;

import java.sql.SQLException;
import java.util.List;

import app.User;
import dbUtilitys.DBUserStatement;

public class Main {

	public static void main(String[] args) {
		
		DBUserStatement dbStatement = new DBUserStatement();
		
		try {
			if (dbStatement.checkDBConnettion()) {
				System.out.println("DB connection established");
			} else {
				System.out.println("DB connection impossible");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		//-------------- create table (if not exists)
//		try {
//			dbStatement.createUserTable();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

//		// insert one 'User' into table
//		try {
//			dbStatement.insertUser(new User("David", "Staron", "davidstaron@mail.de", "Germany"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		// insert a list of 'Users' into table
//		List<User> users = Arrays.asList(
//				new User("Michael", "la Via", "mlav@mail.de", "France"),
//				new User("Marion", "Müller", "m.Müller@gmail.de", "Germany"),
//				new User("Hans", "Hauer", "hansi@mail.de", "Belgium"),
//				new User("Chris", "Carra", "chris.carra@gmail.de", "Italy")
//				);
//		try {
//			dbStatement.insertUsers(users);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		// get user from table where id is ...
//		User user1 = null;
//		try {
//			user1 = dbStatement.getUser(3);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(user1);
		
		// get all user from table
		List<User> users1 = null;
		try {
			users1 = dbStatement.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		users1.forEach(System.out::println);
		System.out.println();
		
//		// delete user
//		try {
//			dbStatement.deleteUser(2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			users1 = dbStatement.getAllUsers();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		users1.forEach(System.out::println);
//		System.out.println();
		
		// insert one 'User' into table
		try {
			dbStatement.insertUser(new User("Nero", "Black", "nero@ship.de", "Matrix"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			users1 = dbStatement.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		users1.forEach(System.out::println);
		System.out.println();
		
		
	}

}

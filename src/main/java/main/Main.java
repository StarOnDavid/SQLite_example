package main;

import java.sql.SQLException;

import app.DBStatement;

public class Main {

	public static void main(String[] args) {
		
		DBStatement dbStatement = new DBStatement();
		
		try {
			dbStatement.checkDBConnettion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

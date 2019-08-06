package com.brainmentors.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {
	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp","root","25911655");
		if(con!=null) {
			System.out.println("Connection Created...");
		}
		else {
			System.out.println("Not Created...");
		}
		return con;
	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		CommonDAO.getConnection();
//
//	}

}

package com.jspider.jdbc_servelet_seprated_statement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcEmployeeConnection {
	
	public static Connection createJdbcEmployeeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/jdbc-m17";
			String username="root";
			String password="root";
			
			 return DriverManager.getConnection(url, username, password);
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}

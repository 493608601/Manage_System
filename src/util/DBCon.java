package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	private Connection connection = null;
	private Statement statement;
	private ResultSet rs;
	
	public DBCon(){
		 // create a database connection
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:/Windows/journal.db");
	        statement = connection.createStatement();
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        statement.executeUpdate("create table if not exists journal (zbld string, zbmj string,"
	        		+ "zbfj string, kssj string,jssj string, gzqk string,bxqk string, bz string,type string,)");
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeAll(){
			try {
				if(connection != null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ResultSet query(String sql){
		 try {
			 rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return rs;
	}
	
	public void update(String sql){
		 try {
			 statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

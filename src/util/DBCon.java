package util;

import java.io.File;
import java.io.IOException;
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
        	File dir = new File("C:/DataBase");
        	if(!dir.exists()) dir.mkdirs();
        	
        	File file = new File("C:/DataBase/journal.db");
        	if(!file.exists()) file.createNewFile();
			connection = DriverManager.getConnection("jdbc:sqlite:C:/DataBase/journal.db");
	        statement = connection.createStatement();
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        statement.executeUpdate("create table if not exists journal (id text PRIMARY KEY, zbld text, zbmj text,"
	        		+ "zbfj text, kssj long, jssj long, bxqk text, bz text, fssj long,"
	        		+ "content text, type text, sxt text)");
	        
		} catch (SQLException | IOException e) {
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

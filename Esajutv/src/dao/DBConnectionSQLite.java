package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;
import util.ConfigReader;


public class DBConnectionSQLite  {
	
	protected  Connection con = null;


	public  Connection getConnection()   {
		String dbUrl = ConfigReader.getProperty("db.path");
        
		String url = "jdbc:sqlite:" + dbUrl ;  

        SQLiteConfig config = new SQLiteConfig();  
        config.enforceForeignKeys(true); 
        
		try { 
	        config = new SQLiteConfig();  
	        config.enforceForeignKeys(true); 
	        
			Class dbDriver = Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url,config.toProperties()); 
			
		} 
		catch	  (Exception e) { e.printStackTrace(); } 		
		
		return con;
	}
	
	public  void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

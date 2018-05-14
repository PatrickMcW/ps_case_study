package com.cdw.dao;

import java.sql.*;
import java.util.*;
import java.io.*;
//import com.mysql.jdbc.MySQLConnection;


public abstract class AbstractDAO {
	protected Connection conn = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;
	
	
	protected void establishConnection() {
		Properties properties = new Properties();
		try {
//			FileInputStream fs = new FileInputStream(
//					///ScrapCaseStudy/src/com/cdw/resources/db.properties
//					//C:\Users\Students\Desktop\Case Study Repo\ScrapCaseStudy\src\com\cdw\resources
////					this.getClass().getClassLoader().getResource("com/cdw/resources/db.properties").getFile() //this is failing after git use?
//					);
			
//			properties.load(fs);
			//the FileInputStream was working before i synced with git, the InputStream version is working after. leaving the above in for reference.
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/cdw/resources/db.properties");
			properties.load(is);
			Class.forName(properties.getProperty("driver"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e){
			//catchall
			e.printStackTrace();
		}
	}
	protected void closeConnection() {
		if(!conn.equals(null)){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

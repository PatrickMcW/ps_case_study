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
		System.out.println("Hello");
		Properties properties = new Properties();
//		System.out.println(properties);
		try {
			FileInputStream fs = new FileInputStream(
					this.getClass().getClassLoader().getResource("com/cdw/resources/db.properties").getFile()
					);
			properties.load(fs);
			Class.forName(properties.getProperty("driver"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
//			System.out.println(url);
			try {
				conn = DriverManager.getConnection(url,user,password);
//				System.out.println(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(conn);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
//		catch (SQLException e){
//			e.printStackTrace();
//		}
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

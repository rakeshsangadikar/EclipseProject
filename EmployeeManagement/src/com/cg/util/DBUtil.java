package com.cg.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	static Connection con;
	
	static public Connection getConnect(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props=new Properties();
			FileInputStream fis;
			fis = new FileInputStream("C:/Users/rsangadi/Pictures/workspace/EmployeeManagement/src/database.properties");
			props.load(fis);
			
			
			String url = props.getProperty("url");
			String user = props.getProperty("username");
			String pass = props.getProperty("password");
			con = DriverManager.getConnection(url, user, pass);
			
			return con;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

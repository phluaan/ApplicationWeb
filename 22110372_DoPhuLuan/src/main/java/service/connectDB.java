package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public static Connection DB () {
		Connection con = null;
		String username = "sa";
        String password = "123456";
        String nameDatabase ="LAPTRINH";
        String nameLap="DESKTOP-LCVENON\\LUAAN";
        String url = "jdbc:sqlserver://"+nameLap+":1433;databaseName="+nameDatabase+";encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("connect successfully!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("connect failure!");
			System.out.println(e);
		} 	
		return con;
	} 
}

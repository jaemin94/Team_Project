package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnectionPool {

	private String id;
	private String pw;
	private String url;
	
	private String userid;
	private String prodid;
	private String useraddr;
	
	
	protected static Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	ConnectionPool()
	{
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/shoppingdb";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn==null) {
				conn = DriverManager.getConnection(url,id,pw); 
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
}

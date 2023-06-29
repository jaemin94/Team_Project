package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Domain.Common.Dto.AddrDto;
import Domain.Common.Dto.OrderDto;

public class OrderDao {

	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public OrderDao()
	{
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/shoppingdb";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public List<OrderDto> select()
	{
		return null;	
	}
	
	public int insert(OrderDto dto)
	{
		return 0;
	}
	
	public int update(OrderDto dto)
	{
		return 0;
	}
	
	public int delete(OrderDto dto)
	{
		return 0;
	}
}

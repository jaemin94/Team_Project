package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Domain.Common.Dto.AddrDto;

public class AddrDao {

	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AddrDao()
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
	
	public List<AddrDto> select()
	{
		return null;	
	}
	
	public int insert(AddrDto dto)
	{
		return 0;
	}
	
	public int update(AddrDto dto)
	{
		return 0;
	}
	
	public int delete(AddrDto dto)
	{
		return 0;
	}
	
}

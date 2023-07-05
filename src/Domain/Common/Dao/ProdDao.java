package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;

public class ProdDao {

	private String id;
	private String pw;
	private String url;
	
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ProdDao instance;
	public static ProdDao getInstance()
	{
		if(instance == null)
			instance = new ProdDao();
		
		return instance;
		
	}
	
	public ProdDao()
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
	
	public List<ProdDto> select()
	{
		List<ProdDto> list = new ArrayList();
		ProdDto dto = null;
		
		try {
			pstmt = conn.prepareStatement("select * from tbl_product");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new ProdDto();
					dto.setProduct_code(rs.getInt("product_code"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setAmount(rs.getInt("amount"));
					dto.setProd_price(rs.getInt("prod_price"));
					list.add(dto);
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
	public ProdDto select(int product_code)throws Exception{
		
		ProdDto dto = null;
		pstmt = conn.prepareStatement("select * from tbl_product where product_code = ?");
		pstmt.setInt(1, product_code);
		rs=pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {

			dto=new ProdDto();
			dto.setProduct_code(rs.getInt("product_code"));
			dto.setProduct_name(rs.getString("product_name"));
			dto.setAmount(rs.getInt("amount"));
			dto.setProd_price(rs.getInt("prod_price"));
			}
		 }
		rs.close();
		pstmt.close();
		return dto;
	}
	
	public int insert(ProdDto dto)
	{
		try {
			pstmt = conn.prepareStatement("insert into tbl_product values(?,?,?,?)");
			pstmt.setInt(1, dto.getProduct_code());
			pstmt.setString(2, dto.getProduct_name());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getProd_price());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(ProdDto dto)
	{
		try {

			pstmt = conn.prepareStatement("update tbl_product set product_name =  ?, amount = ?,prod_price = ? where product_code = ?");

			pstmt.setString(1, dto.getProduct_name());
			pstmt.setInt(2, dto.getAmount());
			pstmt.setInt(3, dto.getProd_price());
			pstmt.setInt(4, dto.getProduct_code());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

	
	public int delete(int code)
	{
		try {
			pstmt = conn.prepareStatement("delete from tbl_product where product_code = ?");
			pstmt.setInt(1, code);
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

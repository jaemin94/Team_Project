package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Domain.Common.Dto.MemberDto;
import Domain.Common.Dto.OrderDto;



public class OrderDao {

	private String id;
	private String pw;
	private String url;
	
	private String userid;
	private String prodid;
	private String useraddr;
	
	
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
		List<OrderDto> list = new ArrayList();
		OrderDto dto = null;
		
		try {
			pstmt = conn.prepareStatement("select * from tbl_order");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new OrderDto();
					dto.setOrder_id(rs.getString("order_id"));
					dto.setMember_id(rs.getString("Member_id"));
					dto.setProduct_code(rs.getInt("product_code"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setAdr_addr(rs.getString("adr_addr"));
					dto.setOdr_amount(rs.getInt("odr_amount"));
					dto.setOdr_date(rs.getDate("odr_date"));
					dto.setPrice(rs.getInt("price"));
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
	
	public int insert(OrderDto dto)
	{
		try {
			pstmt = conn.prepareStatement("insert into tbl_order values(?,null,null,?,null,?,curdate(),?)");
			pstmt.setString(1, dto.getOrder_id());
			pstmt.setString(2, dto.getProduct_name());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getOrder_id());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(OrderDto dto)
	{
		try {
			pstmt = conn.prepareStatement("update tbl_order set member_id = ?, odr_amount = ? , price = ? where  order_id =?");
			pstmt.setString(1, dto.getMember_id());
			pstmt.setInt(2, dto.getOdr_amount());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getOrder_id());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

	
	public int delete(String id)
	{
		try {
			pstmt = conn.prepareStatement("delete from tbl_order where order_id = ?");
			pstmt.setString(1, id);
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

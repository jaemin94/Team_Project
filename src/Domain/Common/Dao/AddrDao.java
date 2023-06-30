package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.AddrDto;
import Domain.Common.Dto.MemberDto;

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
		List<AddrDto> list = new ArrayList();
		AddrDto dto = null;
		try {
			pstmt = conn.prepareStatement("select * from tbl_addr");
			rs = pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					dto = new AddrDto();
					dto.setAddr(rs.getString("adr_addr"));
					dto.setMember_id(rs.getString("member_id"));
					dto.setOrder_id(rs.getString("order_id"));
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
	
	public int insert(AddrDto dto)
	{
		try {
			pstmt = conn.prepareStatement("insert into tbl_addr values(?,null,?)");
			pstmt.setString(1,dto.getAddr());
			pstmt.setString(2,dto.getOrder_id());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int update(AddrDto dto)
	{
		try {
			pstmt = conn.prepareStatement("update tbl_addr set order_id = ? where adr_addr = ?");
			pstmt.setString(1, dto.getOrder_id());
			pstmt.setString(2, dto.getAddr());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(String addr)
	{
		try {
			pstmt = conn.prepareStatement("delete from tbl_addr where adr_addr = ?");
			pstmt.setString(1, addr);
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

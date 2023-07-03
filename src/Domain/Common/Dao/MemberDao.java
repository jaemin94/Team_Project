package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Domain.Common.Dto.MemberDto;

public class MemberDao {

	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDao()
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

	// CRUD
	public int insert(MemberDto dto)
	{
		try
		{
			
			pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getusername());
			pstmt.setString(4, dto.getAdr_addr());
			pstmt.setString(5, dto.getRole());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;		
	}
	
	public List<MemberDto> select()
	{
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_member");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new MemberDto();
					dto.setId(rs.getString("member_id"));
					dto.setPw(rs.getString("pw"));
					dto.setusername(rs.getString("name"));
					dto.setAdr_addr(rs.getString("adr_addr"));
					dto.setRole(rs.getString("role"));
					list.add(dto);
					
				}
				
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return list;
	}
	
	public MemberDto select(String id)
	{
		
		MemberDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_member where member_id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				rs.next();				
				dto = new MemberDto();
				dto.setId(rs.getString("member_id"));
				dto.setPw(rs.getString("pw"));
				dto.setusername(rs.getString("name"));
				dto.setAdr_addr(rs.getString("adr_addr"));
				dto.setRole(rs.getString("role"));	
				
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dto;
	}

	public int update(MemberDto dto) {
	    
	    try {
	        pstmt = conn.prepareStatement("update tbl_member set pw = ?, name = ?, adr_addr = ?, role = ? where member_id = ?");
	        
	        pstmt.setString(1, dto.getPw());
	        pstmt.setString(2, dto.getusername());
	        pstmt.setString(3, dto.getAdr_addr());
	        pstmt.setString(4, dto.getRole());
	        pstmt.setString(5, dto.getId());
	        
	        int result = pstmt.executeUpdate();
	        pstmt.close();
	        return result;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return 0;
	}



	public int delete(String id)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from tbl_member where member_id =?");
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();	 
			pstmt.close();
			return result;		 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;	
	}
	
	
}

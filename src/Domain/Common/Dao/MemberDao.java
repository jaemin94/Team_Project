package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,null,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
//			pstmt.setString(4, dto.getAdr_addr());
			pstmt.setString(4, dto.getRole());
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
			pstmt = conn.prepareStatement("select * from tbl_book");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new MemberDto();
					dto.setBookcode(rs.getInt("book_code"));
					dto.setBookname(rs.getString("book_name"));
					dto.setPublisher(rs.getString("publisher"));
					dto.setIsbn(rs.getString("isbn"));
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
	
	public MemberDto select(int bookcode)
	{
		
		MemberDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_book where book_code=?");
			pstmt.setInt(1, bookcode);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				rs.next();				
				dto = new MemberDto();
				dto.setBookcode(rs.getInt("book_code"));
				dto.setBookname(rs.getString("book_name"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));	
				
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
	
	public List<MemberDto> select(String keyword)
	{
		return null;
	}
	
	public List<MemberDto> select(String keyfield, String keyword)
	{
		return null;
	}

	public int update(MemberDto dto)
	{
		try
		{
			pstmt = conn.prepareStatement("update tbl_book set book_name= ?,publisher=? ,isbn = ?where book_code =?");
			
			pstmt.setString(1, dto.getBookname());
			pstmt.setString(2, dto.getPublisher());
			pstmt.setString(3, dto.getIsbn());
			pstmt.setInt(4, dto.getBookcode());
			
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
	
	public int delete(int bookcode)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from tbl_book where book_code =?");
			pstmt.setInt(1, bookcode);
			
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

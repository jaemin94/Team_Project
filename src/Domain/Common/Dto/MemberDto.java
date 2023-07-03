package Domain.Common.Dto;

public class MemberDto {

	private String id;
	private String pw;
	private String username;
	private String adr_addr;
	private String role;
	
	public MemberDto()
	{
		
	}

	public MemberDto(String id, String pw, String username, String adr_addr, String role)
	{
		this.id = id;
		this.pw = pw;
		this.username = username;
		this.adr_addr = adr_addr;
		this.role = role;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getAdr_addr() {
		return adr_addr;
	}

	public void setAdr_addr(String adr_addr) {
		this.adr_addr = adr_addr;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getRole()
	{
		return role;
	}

	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", username=" + username + ", adr_addr=" + adr_addr + ", role= " + role + "]";
	}
	
	
	
	
}

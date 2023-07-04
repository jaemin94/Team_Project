package Domain.Common.Service.Auth;

import java.util.Map;

public class Session {

	private String sid;
	private String id;
	private String role;
	private String addr;
	Map<String, Object> login_sid;
	
	Session()
	{
		
	}
	
	public Session(String sid, String id, String role, String addr)
	{
		this.sid = sid;
		this.id = id;
		this.role = role;
		this.addr = addr;
	}

	public Session(Map<String, Object> login_sid) {
		this.login_sid = login_sid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String toString() {
		return "Session [sid=" + sid + ", id=" + id + ", role=" + role + ", addr=" + addr + "]";
	}
	
	
	
}

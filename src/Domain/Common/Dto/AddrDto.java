package Domain.Common.Dto;

public class AddrDto {

	private String addr;
	private String member_id;
	private String order_id;
	
	public AddrDto()
	{
		
	}

	public AddrDto(String addr, String member_id, String order_id) 
	{
		this.addr = addr;
		this.member_id = member_id;
		this.order_id = order_id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String toString() {
		return "AddrDto [addr=" + addr + ", member_id=" + member_id + ", order_id=" + order_id + "]";
	}
	
	
	
	
}

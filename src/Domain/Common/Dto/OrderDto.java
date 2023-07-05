package Domain.Common.Dto;

import java.util.Date;

public class OrderDto {

	private String order_id;
	private String member_id;
	private int product_code;
	private String product_name;
	private String adr_addr;
	private int odr_amount;
	private Date odr_date;
	private int price;
	
	public OrderDto()
	{
		
	}
	
//	public OrderDto(String member_id, int odr_amount, int price, String order_id)
//	{
//		this.member_id = member_id;
//		this.odr_amount = odr_amount;
//		this.price = price;
//		this.order_id = order_id;
//	}
	
	public OrderDto(String order_id, String member_id, int product_code, String product_name, String adr_addr,
			int odr_amount, Date odr_date, int price) 
	{
		this.order_id = order_id;
		this.member_id = member_id;
		this.product_code = product_code;
		this.product_name = product_name;
		this.adr_addr = adr_addr;
		this.odr_amount = odr_amount;
		this.odr_date = odr_date;
		this.price = price;
	}
	
	public OrderDto(String member_id,int product_code,int odr_amount)
	{
		this.member_id = member_id;
		this.product_code = product_code;
		this.odr_amount = odr_amount;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getAdr_addr() {
		return adr_addr;
	}

	public void setAdr_addr(String adr_addr) {
		this.adr_addr = adr_addr;
	}

	public int getOdr_amount() {
		return odr_amount;
	}

	public void setOdr_amount(int odr_amount) {
		this.odr_amount = odr_amount;
	}

	public Date getOdr_date() {
		return odr_date;
	}

	public void setOdr_date(Date odr_date) {
		this.odr_date = odr_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", member_id=" + member_id + ", product_code=" + product_code
				+ ", product_name=" + product_name + ", adr_addr=" + adr_addr + ", odr_amount=" + odr_amount
				+ ", odr_date=" + odr_date + ", price=" + price + "]";
	}


	
	
	
	
}

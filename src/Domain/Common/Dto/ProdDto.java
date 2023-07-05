package Domain.Common.Dto;

public class ProdDto {

	private int product_code;
	private String product_name;
	private int amount;
	private int prod_price;
	
	public ProdDto()
	{
		
	}

	public ProdDto(int product_code, String product_name, int amount, int prod_price) 
	{
		this.product_code = product_code;
		this.product_name = product_name;
		this.amount = amount;
		this.prod_price = prod_price;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String toString() {
		return "ProdDto [product_code=" + product_code + ", product_name=" + product_name + ", amount=" + amount
				+ ", prod_price=" + prod_price + "]";
	}

	
	
	
	
	
}
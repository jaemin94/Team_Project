package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dao.ProdDao;
import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;

public class ProductService {
	
	private ProdDao dao;
	
	//singleton
	private static ProductService instance;
	public static ProductService getInstance() {
		if(instance==null)
			instance = new ProductService();
		return instance;
	}
	
	//
	private MemberService memberService;
	
	public ProductService() {
		dao = new ProdDao();
		memberService = MemberService.getInstance();
	}
	
	//+reqAllProd(String sid) : List<ProdDto>
	public List<ProdDto>reqAllProd() throws Exception{
		System.out.println("Product Service's reqAllProd()");
		return dao.select();
	}
	
	
	//+ reqProd(String sid, int product_code) : boolean
	public ProdDto reqProd(int product_code) throws Exception{
		System.out.println("Product Services's reqProd()");
		return dao.select(product_code);
	}
	
	//+ addProd(String sid, int product_code, String product_name): boolean
	public boolean addProd(String id, ProdDto dto) throws Exception{
		System.out.println("ProdService's addProd()");
		String role = memberService.getRole(id);
		if(role.equals("Role_Member")) {
			int result = dao.insert(dto);
			if(result >0)
				return true;
		}
		return false;
	}
	
	//+updateProd(String sid, int prodcuct_code) : boolean
	public boolean updateProd(String id, ProdDto dto) throws Exception {
		System.out.println("Product Services's updateProd()");
		String role = memberService.getRole(id);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.update(dto);
			if(result>0)
				return true;
		}
		return false;
	}
	
	//+romoveProd(String sid, int product_code) : boolean
	public boolean removeProd(String sid, int product_code) throws Exception{
		System.out.println("ProductService's removeProd()");
		String role = memberService.getRole(sid);
		if(role.equals("ROLE_MEMBER")) {
			int result = dao.delete(product_code);
			if(result >0)
				return true;
		}
		return false;
	}
	
	public int Prod_amount(int amount)
	{
		ProdDto pDto = new ProdDto();
		OrderDto oDto = new OrderDto();
		amount = 0;
		
		if(pDto.getAmount() > oDto.getOdr_amount())
		{
			amount = pDto.getAmount() -  oDto.getOdr_amount();
		}
		else
		{
			System.out.println("재고가 없습니다");
		}
		
		return amount;
	}
	
}

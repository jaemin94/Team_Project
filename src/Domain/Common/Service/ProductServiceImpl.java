package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dao.ProdDao;
import Domain.Common.Dao.ProdDaoimpl;
import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;

public class ProductServiceImpl implements ProductService {
	
	private ProdDao dao;
	private MemberService memberService;
	
	//singleton
	private static ProductService instance;
	public static ProductService getInstance() {
		if(instance==null)
			instance = new ProductServiceImpl();
		return instance;
	}
	
	
	public ProductServiceImpl() {
		dao = new ProdDaoimpl();
		memberService = MemberServiceImpl.getInstance();
	}
	
	// 상품 전체 조회
	public List<ProdDto>reqAllProd() throws Exception{
		System.out.println("Product Service's reqAllProd()");
		return dao.select();
	}
	
	
	// 상품 단건 조회
	public ProdDto reqProd(int product_code) throws Exception{
		System.out.println("Product Services's reqProd()");
		return dao.select(product_code);
	}
	
	// 상품 추가하기
	public boolean addProd(String id, ProdDto dto) throws Exception{
		System.out.println("ProdService's addProd()");
		String role = id;
		if(role.equals("Role_Member")) {
			int result = dao.insert(dto);
			if(result >0)
			
				return true;
		}
		return false;
	}
	
	// 상품 수정하기
	public boolean updateProd(String id, ProdDto dto) throws Exception {
		System.out.println("Product Services's updateProd()");
//		String role = memberService.getRole(id);
		String role = id;
		System.out.println(role);
		if(role.equals("Role_Member")) {
			
			int result = dao.update(dto);
			if(result>0)
				
				return true;
		}
		return false;
	}
	
	// 상품 주문시 재고 자동 업데이트
	public boolean updateProdAmount(int product_code, ProdDto dto) throws Exception {
		System.out.println("Product Services's updateProd()");
		String id = null;
		
		String role = id;
		if(role.equals("Role_Member")) {
			int result = dao.update(dto);
			if(result>0)
				return true;
		}
		
		return false;
	}
	
	// 상품 삭제하기
	public boolean removeProd(String sid, int product_code) throws Exception{
		System.out.println("ProductService's removeProd()");
//		String role = memberService.getRole(sid);
		String role = sid;
		if(role.equals("Role_Member")) {
			int result = dao.delete(product_code);
			if(result >0)
				return true;
		}
		return false;
	}
	
	
}

package Domain.Common.Service;

import java.util.List;
import java.util.UUID;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.OrderDao;
import Domain.Common.Dao.ProdDao;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;

public class OrderService {
	
	private MemberService memberService;
	private ProductService productService;
	private OrderDao oDao;
	private MemberDao mDao;
	private ProdDao pDao;
	private static OrderService instance;
	
	public OrderService getInstance()
	{
		if(instance == null)
		{
			instance = new OrderService();
		}
		return instance;
	}
	
	public OrderService()
	{
		oDao = OrderDao.getInstance();
		mDao = MemberDao.getInstance();
		pDao = ProdDao.getInstance();
		memberService = MemberService.getInstance();
		productService = ProductService.getInstance();
		
	}
	
		
//		public boolean reqOrder(String sid, String id,int product_code, int odr_amount) throws Exception {
//			MemberDto mdto = new MemberDto();
//			ProdDto pdto = new ProdDto();
//			OrderDto odto = new OrderDto();
//			
//			String role = memberService.getRole(sid);
//			if (!role.equals("Role_Member")) {
//				System.out.println("[WARN] 관리자만 로그인 할 수 있습니다.");
//				return false;
//			}
//			
//		    mdto = memberService.memberSearchOne("Role_user", id);
//		    if (mdto != null) {
//		    	pdto = productService.reqProd(product_code); 
//		        if (pdto != null) {
//		        	
//		        	
//		            int currentStock = pdto.getAmount();
//		            
//		           
//		            	if (currentStock >= odr_amount) {
//		                int updatedStock = currentStock - odr_amount;
//		                pdto.setAmount(updatedStock);
//		                productService.updateProdAmount(product_code, pdto);
//		                int pp = odr_amount * pdto.getProd_price();
//		                
//		                String oid = UUID.randomUUID().toString();
//		                odto.setOrder_id(oid); // 주문 ID 설정
//		                odto.setProduct_code(product_code);
//		                oDao.insert(new OrderDto("1",mdto.getId(),pdto.getProduct_code(),pdto.getProduct_name(),mdto.getAdr_addr(),odr_amount,null,pp));
//            	
//		                System.out.println("[INFO] 주문완료");		                
//		                return true;	            
//		            }		                         
//		            else 
//		            {
//		                System.out.println("[INFO] 주문 수량이 재고보다 많습니다.");
//		                return false;
//		            }
//		    }
//		       else 
//		       {
//		            System.out.println("[INFO] 해당 상품이 존재하지 않습니다.");
//		            return false;
//		       }
//		  
//		    }
//		    	else
//		    {
//		        System.out.println("[INFO] 해당 회원이 존재하지 않습니다.");
//		        return false;
//		    }
//}
//	
		
		// ---------------------------------------------------------------- 테스트 ------------------------------------------
		
		// -------------------------------------------------------------------------------------- 민영씨 코드
		public boolean reqOrder(String sid, String id, int product_code, int odr_amount) throws Exception {
		    MemberDto mdto = new MemberDto();
		    ProdDto pdto = new ProdDto();
		    OrderDto odto = new OrderDto();

		    String role = memberService.getRole(sid);
		    if (!role.equals("Role_user")) {
		        System.out.println("[WARN] 회원만 로그인 할 수 있습니다.");
		        return false;
		    }

		    mdto = memberService.memberSearchOne(role, id);
		    if (mdto != null) {
		        pdto = productService.reqProd(product_code);
		        if (pdto != null) {
		            int currentStock = pdto.getAmount();
		            if (currentStock >= odr_amount) {
		                int updatedStock = currentStock - odr_amount;
		                pdto.setAmount(updatedStock);
		                // tbl_product 의 내용 수정(ok)
		                
		                // insert 유무에 관하여 T/F 설정
		                boolean updateSuccess = productService.updateProdAmount(product_code, pdto); // 현재 상품재고량 수정

		                // insert가 되면 상품 재고 업데이트를 실행
		                if (updateSuccess) {
		                    int pp = odr_amount * pdto.getProd_price();
		                    String oid = UUID.randomUUID().toString();

		                    odto.setOrder_id(oid); // 주문 ID 설정
		                    odto.setProduct_code(product_code);

		                    // tbl_order 의 내용 추가(x)
		                    
		                    // insert 여부를 확인하는 코드
		                    int insertSuccess = oDao.insert(new OrderDto(oid, mdto.getId(), pdto.getProduct_code(),
		                            pdto.getProduct_name(), mdto.getAdr_addr(), odr_amount, null, pp));

		                    // insert 가 무사히 되었을시 true값을 리턴
		                    if (insertSuccess==1) {
		                        System.out.println("[INFO] 주문완료");
		                        return true;
		                        
		                    } 
		                    // insert가 되지 않았을시에 false값을 리턴
		                    else {
		                        System.out.println("[INFO] 주문 내역 추가 실패");
		                        // 주문 내역 추가 실패 시 상품 재고량을 원래대로 복구
		                        pdto.setAmount(currentStock);
		                        productService.updateProdAmount(product_code, pdto);
		                        return false;
		                    }
		                } 
		                // insert가 되지 않았을시 상품재고량 업데이트하지 않고 false 값을 리턴
		                else {
		                    System.out.println("[INFO] 상품 재고량 업데이트 실패");
		                    return false;
		                }
		            } else {
		                System.out.println("[INFO] 주문 수량이 재고보다 많습니다.");
		                return false;
		            }
		        } else {
		            System.out.println("[INFO] 해당 상품이 존재하지 않습니다.");
		            return false;
		        }
		    } else {
		        System.out.println("[INFO] 해당 회원이 존재하지 않습니다.");
		        return false;
		    }
		}
		
		
		//-----------------------------------------------------------------------------------------
		
		
		// ---------------------------------------------------------------- 테스트 ------------------------------------------		
		    
		
		// 주문 전체확인
	public List<OrderDto> getOrder()
	{
//		String role = this.memberService.getRole(sid);
//		
//		if(role.equals("Role_Member"))		
			return oDao.select();
		
//		return null;	
	}
	
	// 건별 주문 확인
	public OrderDto getOrder(String role,String order_id)
	{
		if(role.equals("Role_member"))		
			return oDao.select(order_id);
		
		return null;
		
	}
	
	// 주문하기
	public boolean addOrder(OrderDto dto, String login_sid)
	{
		System.out.println("OrderService's addOrder()");
		
		String role = memberService.getRole(login_sid);
		
		if(role.equals("Role_Member"))
		{
		int result = oDao.insert(dto);
		if(result > 0)
			return true;
		}
		return false;
		
	}
	
	// 주문정보 수정
	public boolean updateOrder(OrderDto dto, String login_sid)
	{
		System.out.println("OrderService's updateOrder()");
		
		String role = memberService.getRole(login_sid);
		
		if(role.equals("Role_Member"))
		{
		int result = oDao.update(dto);
		if(result > 0)
			return true;
		}
		return false;
	}
	

	
	// 주문 완료 및 취소 처리
	public boolean removeOrder(String order_id, String login_sid)
	{
		System.out.println("BookService's removeOrder()");
		String role = memberService.getRole(login_sid);
		if(role.equals("Role_Member"))
		{
		int result = oDao.delete(order_id);
		if(result > 0)
			return true;
		}
		return false;
	}


	
	

}
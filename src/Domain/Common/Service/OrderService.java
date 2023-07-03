package Domain.Common.Service;

import java.util.List;

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
	
	private OrderService()
	{
		oDao = OrderDao.getInstance();
		mDao = MemberDao.getInstance();
		pDao = ProdDao.getInstance();
		memberService = MemberService.getInstance();
		productService = ProductService.getInstance();
		
	}
	
	// 주문 가능한지
	// MemberDao를 참고하여 회원 아이디와 주소 , ProdDao 를 참고하여 prodcut_code를 주문 테이블에 넣는 작업
	public boolean reqOrder(String sid, String id,int product_code,String order_id,
							String member_id,String product_name,String adr_addr,int odr_amount,int price)
	{
		// 사서 로그인 확인, Role 받기
				String role = memberService.getRole(sid);
				if(!role.equals("Role_Member"))
					{
						System.out.println("[WARN] 사서만 로그인 할 수 있습니다.");
						return false;
					}
				// 회원 존재 유무 확인
				MemberDto dto = memberService.memberSearchOne(role, id);
				
				if(dto != null)
				{
					// 도서존재 유무 확인
					ProdDto pdto = productService.reqProd(product_code);
					if(pdto != null)
					{
						// 책이 존재한다면 대여중인 상태인지 확인(RentalDao이용해서 대여중인 책이 있는지 조회)
						OrderDto odto = oDao.select(order_id);
						if(odto == null)
						{
							// 대여가능 상태라면 대여진행
							oDao.insert(new OrderDto(order_id,member_id,product_code,product_name,adr_addr,odr_amount,null,price));
							System.out.println("[INFO] 도서대여 완료되었습니다.");
							return true;
						}
						System.out.println("[INFO] 요청한 도서는 대여중입니다.");
						return false;
					}
					System.out.println("[INFO] 해당 도서는 존재하지 않습니다.");
					return false;
				}
				System.out.println("[INFO] 해당 회원이 존재하지 않습니다.");
				return false;
			}
		
	}
	
	// 모드 주문확인
	public List<OrderDto> getAllOrder(OrderDto dto)
	{
		System.out.println("OrderService's getAllOrder()");
		return oDao.select();
		
	}
	
	// 건별 주문 확인
	public OrderDto getOrder(String order_id)
	{
		System.out.println("OrderService's getOrder()");
		return oDao.select(order_id);
		
	}
	
	// 주문하기
	public boolean addOrder(OrderDto dto, String sid)
	{
		System.out.println("OrderService's addOrder()");
		
		String role = memberService.getRole(sid);
		
		if(role.equals("Role_Member"))
		{
		int result = oDao.insert(dto);
		if(result > 0)
			return true;
		}
		return false;
		
	}
	
	// 주문정보 수정
	public boolean updateOrder(OrderDto dto, String sid)
	{
		System.out.println("OrderService's updateOrder()");
		
		String role = memberService.getRole(sid);
		
		if(role.equals("Role_Member"))
		{
		int result = oDao.update(dto);
		if(result > 0)
			return true;
		}
		return false;
	}
	
	// MemberDao를 참고하여 회원 아이디와 주소 , ProdDao 를 참고하여 prodcut_code를 주문 테이블에 넣는 작업
//	public boolean updateOrder(MemberDto mdto, String id, String addr, ProdDto pdto, int product_code,String sid)
//	{
//		System.out.println("OrderService's updateOrder()");
//		
//		String role = memberService.getRole(sid);
//		
//		if(role.equals("Role_Member"))
//		{
//		int result = oDao.update(mdto);
//		if(result > 0)
//			return true;
//		}
//		return false;
//	}
	
	// 주문 완료 및 취소 처리
	public boolean removeOrder(String order_id, String sid)
	{
		System.out.println("BookService's removeOrder()");
		String role = memberService.getRole(sid);
		if(role.equals("Role_Member"))
		{
		int result = oDao.delete(order_id);
		if(result > 0)
			return true;
		}
		return false;
	}
	
	

}

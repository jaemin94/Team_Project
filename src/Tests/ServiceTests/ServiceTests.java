package Tests.ServiceTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;
import Domain.Common.Service.OrderService;

public class ServiceTests {

//	@Test
//	public void test() throws Exception {
//		OrderService service = new OrderService();
//		MemberService memberService = new MemberService();
//		assertNotNull(service);
//		
//		Map<String, Object> login_sid = memberService.login("member1", "1234");
//		
//		System.out.println("sid: " + login_sid);
//		
//		
//		boolean islend = service.reqOrder(login_sid,"member1",4);
//	}
//	
//	@Test
//	public void test2() throws Exception {
//		OrderService service = new OrderService();
//		MemberService memberService = new MemberService();
//		assertNotNull(service);
//		
//		Map<String, Object> login_sid = memberService.login("member1", "1234");
//		
//		System.out.println("sid: " + login_sid);
//		
//		
//		List<OrderDto> list = service.getAllOrder();
//		list.stream().forEach((dto)->{System.out.println(dto);});
//	}
	
	   @Test
	    void testProcessOrderSuccess() {
	        ProdDto pDto = new ProdDto();
	        OrderDto oDto = new OrderDto();

	        pDto.setAmount(100);
	        oDto.setOdr_amount(50);

	        String result = OrderService.processOrder(pDto, oDto);
	        assertEquals("주문이 성공적으로 완료되었습니다. 남은 상품 수량: 50", result);

	        // 확인: 남은 상품 수량이 정확한지 확인
	        assertEquals(50, pDto.getAmount());
	    }

	    @Test
	    void testProcessOrderFail() {
	        ProdDto pDto = new ProdDto();
	        OrderDto oDto = new OrderDto();

	        pDto.setAmount(100);
	        oDto.setOdr_amount(150);

	        String result = OrderService.processOrder(pDto, oDto);
	        assertEquals("주문량이 상품 수량을 초과했습니다. 주문을 처리할 수 없습니다.", result);

	        // 확인: 상품 수량이 변경되지 않았는지 확인
	        assertEquals(100, pDto.getAmount());
	    }
	}
//	@Test
//	public void test2() throws Exception {
//		ProductService pService = new ProductService();
//		MemberService memberService = new MemberService();
//
//		
//		Map<String, Object> login_sid = memberService.login("member1", "1234");
//		
//		System.out.println("sid: " + login_sid);
//		
//		pService.addProd("member1",new ProdDto(3,"이것이 리눅스다",100));
//		
//		
//	}
	
	
//	@Test
//	public void test1() throws Exception {
////		ProductService service = new ProductService();
//		OrderService service = new OrderService();
//		MemberService memberService = new MemberService();
//		assertNotNull(service);
//		
//		Map<String, Object> login_sid = memberService.login("member1", "1234");
//		boolean list = service.removeOrder("member1",login_sid);
//		System.out.println(list);
//	}
	
	
	
//	@Test
//	public void test3_MemberService_login() throws Exception{
//		
//		MemberService service = new MemberService();
////		assertNotNull(service);
//		Map<String, Object> sid = service.login("user1", "1234");
//		System.out.println("sid: " + sid);
//		Session mySession = service.sessionMap.get(sid);
//		System.out.println("mySession : " + mySession);
//	}

}

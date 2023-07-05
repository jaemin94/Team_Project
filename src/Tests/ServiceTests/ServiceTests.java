package Tests.ServiceTests;

<<<<<<< HEAD
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import Domain.Common.Dto.ProdDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.OrderService;
import Domain.Common.Service.ProductService;
=======
import org.junit.Test;

import Domain.Common.Dao.OrderDao;
import Domain.Common.Dto.OrderDto;
import Domain.Common.Service.OrderService;
>>>>>>> 2b424ee8338ed23ea3cf5d7a8977cc433fcc8b7c

public class ServiceTests {

//	@Test
//	public void test() throws Exception {
//		OrderService service = new OrderService();
<<<<<<< HEAD
//		MemberService memberService = new MemberService();
//		assertNotNull(service);
//		
//		Map<String, Object> login_sid = memberService.login("member9", "1234");
//		
//		System.out.println("sid: " + login_sid);
//		
//		
//		boolean islend = service.reqOrder("user1",4);
=======
//	    MemberService memberService = new MemberService();
//	    assertNotNull(service);
//	    
//	    // 로그인 정보 가져오기
//	    Map<String, Object> login_sid = memberService.login("user1", "1234");
//	    System.out.println("sid: " + login_sid);
//	    
//	    // 주문 요청 테스트
//	    boolean isOrderSuccessful = service.reqOrder("user1", "user1",2, 5);
//	    System.out.println("주문 성공 여부: " + isOrderSuccessful);
>>>>>>> 2b424ee8338ed23ea3cf5d7a8977cc433fcc8b7c
//	}
	@Test
	public void test() throws Exception {
		OrderService service = new OrderService();
		OrderDto dto = service.getOrder("Role_Member", "1");
		System.out.println(dto.toString());
		
		
		
	}
//	
	@Test
	public void test() throws Exception {
	    OrderService service = new OrderService();
	    MemberService memberService = new MemberService();
	    assertNotNull(service);
	    
	    Map<String, Object> login_sid = memberService.login("member1", "1234");
	    
	    System.out.println("sid: " + login_sid);
	    
	    boolean isOrderSuccessful = service.reqOrder("member1","user1",3, 4);
	    System.out.println("주문 성공 여부: " + isOrderSuccessful);
	}

	
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
	
<<<<<<< HEAD
	@Test
	public void test2() throws Exception {
		ProductService pService = new ProductService();
		MemberService memberService = new MemberService();

		
		Map<String, Object> login_sid = memberService.login("member1", "1234");
		
		System.out.println("sid: " + login_sid);
		
		pService.addProd("member1",new ProdDto(2,"청바지",100,500));
		
		
	}
=======
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
>>>>>>> 2b424ee8338ed23ea3cf5d7a8977cc433fcc8b7c
	
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

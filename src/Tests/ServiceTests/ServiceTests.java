package Tests.ServiceTests;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import Domain.Common.Service.MemberService;
import Domain.Common.Service.OrderService;
import Domain.Common.Service.Auth.Session;

public class ServiceTests {

	@Test
	public void test() throws Exception {
		OrderService service = new OrderService();
		MemberService memberService = new MemberService();
		assertNotNull(service);
		
		Map<String, Object> login_sid = memberService.login("user1", "1234");
		
		System.out.println("sid: " + login_sid);
		
		
		boolean islend = service.reqOrder(login_sid,"user1",4);
	}
	
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

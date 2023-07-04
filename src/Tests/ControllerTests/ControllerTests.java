package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Controller.FrontController;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.Auth.Session;

public class ControllerTests {

	@Test
	public void test() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
		controller.execute("/product",1,null);
	}
	
	@Test
	public void test1() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
	
		Map<String, Object> param = new HashMap();
		param.put("product_code", 1);
		controller.execute("/product",2,param);
		
	}
	
	@Test
	public void test1_member() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
	
		Map<String, Object> param = new HashMap();

		controller.execute("/member",1,null);
		
	}
	
	@Test
	public void test2_member() {
		MemberService ms = new MemberService(); 

		try {
			Map<String, Object> tmp = ms.login("1234", "1234");
			
			ms.memberSearch(tmp.get("sid").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

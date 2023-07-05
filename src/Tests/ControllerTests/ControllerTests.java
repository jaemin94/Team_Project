package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import Controller.FrontController;
import Controller.OrderController;

public class ControllerTests {

	
	public void test() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
		controller.execute("/product",1,null);
	}
	
	
	public void test2() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
	
		Map<String, Object> param = new HashMap();
		param.put("product_code", 1);
		controller.execute("/product",2,param);
		
	}
	

}

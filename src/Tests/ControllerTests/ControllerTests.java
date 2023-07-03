package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


import Controller.FrontController;

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

}

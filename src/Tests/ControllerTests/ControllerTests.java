package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Controller.FrontController;

public class ControllerTests {

	@Test
	public void test() {
		FrontController controller = new FrontController();
		assertNotNull(controller);	
		controller.execute("/member",1,null);
	}

}

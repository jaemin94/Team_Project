package Tests.ControllerTests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Controller.MemberController;
import Controller.OrderController;

public class asd {

	@Test
	public void test() {
		OrderController con = new OrderController();
		MemberController controller = new MemberController();
		
		Map<String,Object> param = new HashMap();
		param.put("id", "user1");
		param.put("pw", "1234");
		
		// SID 발급
		Map<String,Object> result = controller.execute(5,param);
		String sid = (String)result.get("result");
		System.out.println("로그인 성공! Sid : " + sid);
		
		Map<String, Object> param1 = new HashMap();
		param1.put("member_id", "user1");
		param1.put("product_code", 1);
		param1.put("odr_amount", 1);
		param1.put("price", 0);
		
		con.execute(3, param1);
		
	}

}

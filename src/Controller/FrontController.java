package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	
	private Map<String,SubController> map = new HashMap();
	
	
	// 초기값 설정
	private void init()
	{
		// 주문 정보 요구 사항 - > 컨트롤러 맵핑
		map.put("/order",new OrderController());
		
		// 회원 정보 요구 사항 - > 컨트롤러 맵핑
		map.put("/member",new MemberController());
		
		// 상품 정보 요구 사항 - > 컨트롤러 맵핑
		map.put("/product",new ProductController());
	}
	
	public FrontController()
	{
		init();
	}
	
	// 각 컨트롤러에 맞게 다운캐스팅 해주면서 어떠한 서비스를 사용할건지 지정
	public Map<String,Object> execute(String request,int serviceNo,Map<String,Object> param)
	{
		SubController controller = map.get(request);
		Map<String,Object> result = new HashMap();
		result = controller.execute(serviceNo,param);

		
		return result;
		
	}
	
	
	
}

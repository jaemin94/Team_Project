package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	
	private Map<String,Object> map = new HashMap();
	
	
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
	
	FrontController()
	{
		init();
	}
	
	// 각 컨트롤러에 맞게 다운캐스팅 해주면서 어떠한 서비스를 사용할건지 지정
	public Map<String,Object> execute(String request,int serviceNo,Map<String,Object> param)
	{
		Object controller = map.get(request);
		Map<String,Object> result = new HashMap();
		
		if(controller instanceof MemberController)
		{
			MemberController down = (MemberController) controller;
			result = down.execute(serviceNo,param);
			System.out.println("MemberController !");
		}
		else if(controller instanceof OrderController)
		{
			OrderController down = (OrderController) controller;
			result = down.execute(serviceNo,param);
			System.out.println("OrderController !");
		}
		else if(controller instanceof ProductController)
		{
			ProductController down = (ProductController) controller;
			result = down.execute(serviceNo,param);
			System.out.println("ProductController !");
		}
		else
		{
			System.out.println("System ERROR please try again");
		}
		
		return result;
		
	}
	
	
	
}

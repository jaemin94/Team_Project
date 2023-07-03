package Controller;

import java.util.Map;

import Domain.Common.Dto.OrderDto;
import Domain.Common.Service.OrderService;

public class OrderController {

	OrderService service;
	
	public OrderController(){
		service = OrderService.getInstance();
//	private String order_id;
//	private String member_id;
//	private int product_code;
//	private String product_name;
//	private String adr_addr;
//	private int odr_amount;
//	private Date odr_date;
//	private int price;
	}
	
	// 1 Select , 2 Insert , 3 Update , 4 Delete
	public Map<String,Object> execute (int serviceNo,Map<String,Object> param){
		if (serviceNo == 1) {
			// 1 파라미터 추출
			String member_id = (String) param.get("member_id");
			String sid=(String)param.get("sid");
			// 2 입력값 검증
			if(sid==null||member_id==null) {
				System.out.println("[ERROR] Data Validation Check..");
				return null;
			}
			// 3 서비스 실행(서비스모듈작업 이후 처리)
			// service.getAllLend(sid);
			
			// 4 View로 전달
			System.out.println("Order_select Block!");
	}	else if (serviceNo == 2) {
		// 1 파라미터 추출
		String order_id = (String) param.get("order_id");
		String member_id = (String) param.get("member_id");
		Integer product_code = (Integer) param.get("product_code");
		String product_name = (String) param.get("product_name");
		String adr_addr = (String) param.get("adr_addr");
		Integer odr_amount = (Integer) param.get("odr_amount");
		Integer price = (Integer) param.get("price");
		String sid=(String) param.get("sid");
		
		// 2 입력값 검증
		if(order_id==null||member_id==null||product_code==null||product_name==null||adr_addr==null||odr_amount==null||price==null||sid==null) {
			System.out.println("[ERROR]Data Validation Check Error");
			return null;
		}
		// 3 서비스 실행
		OrderDto dto = new OrderDto(order_id,member_id,product_code,product_name,adr_addr,odr_amount,null,price);
		System.out.println("Dto : " + dto);
		
		
//		Boolean rValue=false;
//		try {
//			rValue = service.reqOrder(sid, member_id, order_id);
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		
		// 4 View로 전달
//		System.out.println("Order_insert Block!");
//		Map<String,Object> result = new HashMap();
//		result.put("result", rValue);
//		return result;
	
} else if (serviceNo == 3) {
	// 1 파라미터 추출
	String order_id = (String) param.get("order_id");
	String member_id = (String) param.get("member_id");
	Integer product_code = (Integer) param.get("product_code");
	String product_name = (String) param.get("product_name");
	Integer odr_amount = (Integer) param.get("odr_amount");
	Integer price = (Integer) param.get("price");
	String sid=(String) param.get("sid");
	
	// 2 입력값 검증
			if(order_id==null||member_id==null||product_code==null||product_name==null||odr_amount==null||price==null||sid==null) {
				System.out.println("[ERROR]Data Validation Check Error");
				return null;
			}
			
			// 3 서비스 실행
			OrderDto dto = new OrderDto(order_id,member_id,product_code,product_name,adr_addr,odr_amount,null,price);
			System.out.println("Dto : " + dto);
} else if (serviceNo == 4) {
	// 1 파라미터 추출
	String member_id = (String) param.get("member_id");
	String sid=(String) param.get("sid");
	
	// 2 입력값 검증
				if(member_id==null||sid==null) {
					System.out.println("[ERROR]Data Validation Check Error");
					return null;
				}
				// 3 서비스 실행
				OrderDto dto = new OrderDto(order_id,member_id,product_code,product_name,adr_addr,odr_amount,null,price);
				System.out.println("Dto : " + dto);
}
	return null;
}
}
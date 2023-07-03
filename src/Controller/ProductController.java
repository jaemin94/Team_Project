package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Common.Service.ProductService;

//
//ProdService
//
//- memberService : MemberService
//
//- dao : prodDao
//
//- instance() : ProdService
//
//+ reqProd(String sid, int product_code) : boolean
//
//+ addProd(String sid, int product_code, String product_name)
//
//: boolean
//
//+updateProd(String sid, int prodcuct_code) : boolean
//
//+romoveProd(String sid, int product_code) : boolean
//
//+ getInstance() : ProdService





public class ProductController {
	private ProductService service;
	public ProductController() {
		service = ProductService.getInstance();
	}
	
	
	public Map<String,Object> execute (int serviceNo, Map<String,Object>param){
		if(serviceNo==1) {
			String sid = (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			
			if(sid==null||product_code==null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			
			Boolean rValue = false;
			rValue =service.reqProd(product_code);
			Map<String,Object>result = new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo==2) {
			String sid = (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			String product_name = (String)param.get("product_name");
//			Integer amount = (Integer)param.get("amount");
			if(sid==null||product_code==null||product_name == null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			Boolean rValue = false;
			rValue = service.addProd(sid,product_code,product_name);
			System.out.println("Product_Add Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}else if(serviceNo==3) {
			String sid = (String)param.get("sid";)
			Integer product_code = (Integer)param.get("product_code");
			if(sid==null||product_code==null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			Boolean rValue=false;
			rValue=service.updateProd(sid,product_code);
			System.out.println("Product_Add Block!");
			Map<String,Object>result= new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo==4) {
			String sid= (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			if(sid==null||product_code==null) {
				System.out.println("[ERROR]Data Validation Check Error");
				return null;
			}
			Boolean rValue = false;
			rValue=service.removeProd(sid,product_code);
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
	}

	return null;
}
}

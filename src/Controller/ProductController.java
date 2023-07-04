package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Common.Dto.ProdDto;
import Domain.Common.Service.ProductService;



public class ProductController {

	
	private ProductService service;
	
	public ProductController() {
		service = ProductService.getInstance();
	}

	public Map<String,Object> execute (int serviceNo, Map<String,Object>param){
		
		if(serviceNo==1) {
			List<ProdDto> list = null;
			try {
				list = service.reqAllProd();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			System.out.println("Prod_Select All Block!");
			Map<String,Object>result = new HashMap();
			result.put("result", list);
			return result;
			
		}else if(serviceNo==2) {
			String sid = (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			
			if(sid==null||product_code==null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			
			ProdDto dto = null;
			try {
				dto =service.reqProd(product_code);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			Map<String,Object>result = new HashMap();
			result.put("result", dto);
			return result;
			
			
			
		}else if(serviceNo==3) {
			String sid = (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			String product_name = (String)param.get("product_name");
			Integer amount = (Integer)param.get("amount");
			Integer prod_price = (Integer)param.get("prod_price");
			
			if(product_code==null||product_name == null || amount ==null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			
			ProdDto dto = new ProdDto(product_code,product_name,amount,prod_price);
			
			Boolean rValue = false;
			try {
				rValue = service.addProd(sid,dto);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Product_Add Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		
		}else if(serviceNo==4) {
			String sid = (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			String product_name = (String)param.get("product_name");
			Integer amount = (Integer)param.get("amount");
			Integer prod_price = (Integer)param.get("prod_price");
			
			
			if(product_code==null||product_name==null||amount==null) {
				System.out.println("[ERROR] Data Validation Check Error");
				return null;
			}
			
			ProdDto dto = new ProdDto(product_code,product_name,amount,prod_price);
			
			Boolean rValue=false;
			try {
				rValue=service.updateProd(sid,dto);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			System.out.println("Product_Add Block!");
			Map<String,Object>result= new HashMap();
			result.put("result", rValue);
			return result;
			
		}else if(serviceNo==5) {
			String sid= (String)param.get("sid");
			Integer product_code = (Integer)param.get("product_code");
			if(sid==null||product_code==null) {
				System.out.println("[ERROR]Data Validation Check Error");
				return null;
			}
			Boolean rValue = false;
			try {
				rValue=service.removeProd(sid,product_code);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		}
		return null;

	}

}

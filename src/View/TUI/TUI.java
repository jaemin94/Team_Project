package View.TUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Dto.OrderDto;
import Domain.Common.Dto.ProdDto;


public class TUI {

	private String sid; // SessionId
	private String id; // UserId
	private Scanner sc = new Scanner(System.in);
	private String role;
	
	private FrontController controller;
	
	TUI()
	{
		controller = new FrontController();
	}
	
	public void MainMenu() {

		while (true) {
			System.out.println("--------------------------");
			System.out.println("MAIN");
			System.out.println("--------------------------");
			System.out.println("1 회원조회");
			System.out.println("2 로그인");
			System.out.println("3 회원가입");
			System.out.println("4 종료");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch(num)
			{
			case 1:
				break;
			case 2:
				loginMenu();
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(-1);
			default:
				break;
			}
		}

	}
	
	public void loginMenu() {
		System.out.println("--------------------------");
		System.out.println("로그인");
		System.out.println("--------------------------");
		System.out.print("ID : " );
		String id = sc.next();
		System.out.print("PW : " );
		String pw = sc.next();
		
		Map<String,Object> param = new HashMap();
		param.put("id", id);
		param.put("pw", pw);
		
		Map<String,Object> result = controller.execute("/member", 6, param);
		
		if(result == null) {
			return;
		}
		
		String sid = (String)result.get("sid");
		String role = (String)result.get("role");

		if(sid != null)
		{
			this.sid = sid;
			this.id = id;
			this.role = role;
		}
		if(role.equals("Role_Member"))
			ManagerMenu();
		else if(role.equals("Role_user"))
			MemberMenu();

	}
	
	public void MemberMenu() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("회원메뉴");
			System.out.println("--------------------------");
			System.out.println("[상품]			[회원]			[주문]");
			System.out.println("11 상품조회하기		21 회원정보조회 	31 주문 전체조회"	);
			System.out.println("12 상품주문하기");	
			System.out.println("0. 로그아웃");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch(num) {
			case 11:
				Map<String, Object> result11memb = controller.execute("/product", 1, null);
				List<ProdDto> list = (List<ProdDto>) result11memb.get("result");
				list.stream().forEach((dto) -> {
					System.out.println("--------------------------");
					System.out.println("상품 이름: " + dto.getProduct_name());
					System.out.println("상품 수량: " + dto.getAmount());
				});
				result11memb = null;
				break;
			case 12:
				System.out.println("--------------------------");
				System.out.print("상품 코드: ");
				int product_code = sc.nextInt();
				System.out.println("상품 수량: ");
				int odr_amount = sc.nextInt();
				Map<String,Object> result12memb = new HashMap();
				result12memb.put("member_id", this.id);
				result12memb.put("product_code", product_code);
				result12memb.put("odr_amount", odr_amount);
				result12memb.put("price", 0);
				result12memb.put("sid", this.sid);
				result12memb.put("role", this.role);
				
				
				Map<String, Object> result12 = controller.execute("/order", 3, result12memb);
				Boolean isOrdered = (Boolean)result12.get("result");
				if(isOrdered == true)
				{
					System.out.println("[INFO] 주문 완료!");
				}
				break;

			case 21 :
				Map<String,Object> member21param = new HashMap();
				member21param.put("sid", sid);
				member21param.put("user_id", this.id);
				
				Map<String, Object> member21result = controller.execute("/member", 2, member21param);
				
				MemberDto member21mdto = (MemberDto) member21result.get("result");
				
				System.out.printf(" user id: %s \n user name: %s \n user address: %s \n", member21mdto.getId(), member21mdto.getusername(), member21mdto.getAdr_addr());
				
				
				
//				List<MemberDto> manager22list = (List<MemberDto>) manager22result.get("result");
//				manager22list.stream().forEach((dto) -> {System.out.println(dto);});
				break;
			case 0 : 
				Map<String,Object> member0param = new HashMap();
				member0param.put("sid", sid);
				controller.execute("/member", 7, member0param);
				return ;
			}
			
		}
	}
	
	public void ManagerMenu() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("관리자메뉴");
			System.out.println("--------------------------");
			System.out.println("[상품]			[회원]			[주문]");
			System.out.println("11 상품조회하기		21 회원전체조회	 	31 주문 전체조회"	);
			System.out.println("12 상품추가하기		22 회원단건조회	 	32 주문 단건조회"		);
			System.out.println("13 상품수정하기 					33 주문 완료삭제	"		);
			System.out.println("14 상품삭제하기									"	);	
			System.out.println("0. 로그아웃");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch(num)
			{
			case 11:
				Map<String, Object> result = controller.execute("/product", 1, null);
				List<ProdDto> list = (List<ProdDto>) result.get("result");
				list.stream().forEach((dto) -> {System.out.println(dto);});
				break;
			case 12:
				System.out.print("상품코드 상품명 재고량 상품가격 입력 : ");
				int product_code = sc.nextInt();
				String product_name = sc.next();
				int amount = sc.nextInt();
				int prod_price = sc.nextInt();
				
				Map<String,Object> param = new HashMap();
				
				param.put("product_code", product_code);
				param.put("product_name", product_name);
				param.put("amount", amount);
				param.put("prod_price", prod_price);
				param.put("sid", sid);
				
				Map<String,Object> result2 = controller.execute("/product",3,param);
				Boolean isInsert = (Boolean)result2.get("result");
				if(isInsert==true)
					System.out.println("[INFO] 상품 등록 완료!");
				
				break;
			case 13:
				
				System.out.print("상품명 재고량 상품가격 상품코드 입력 : ");
				
				String product_name1 = sc.next();
				int amount1 = sc.nextInt();
				int prod_price1 = sc.nextInt();
				int product_code1 = sc.nextInt();
				Map<String,Object> param1 = new HashMap();
				
				param1.put("product_name", product_name1);
				param1.put("amount", amount1);
				param1.put("prod_price", prod_price1);
				param1.put("product_code", product_code1);
				param1.put("sid", sid);
				
				Map<String,Object> result3 = controller.execute("/product",4,param1);
				Boolean isUpdated = (Boolean)result3.get("result");
				if(isUpdated==true)
					System.out.println("[INFO] 상품 수정 완료!");
				break;
				
			case 14 :
				System.out.print("삭제할 상품코드 입력 : ");
				int product_code2 = sc.nextInt();

				
				Map<String,Object> param2 = new HashMap();
				
				param2.put("product_code", product_code2);
				param2.put("sid", sid);
				
				Map<String,Object> result4 = controller.execute("/product",5,param2);
				Boolean isDeleted = (Boolean)result4.get("result");
				if(isDeleted==true)
					System.out.println("[INFO] 상품 삭제 완료!");
				break;
				
			case 21 :
				Map<String,Object> param4 = new HashMap();
				param4.put("sid", sid);
				Map<String, Object> result5 = controller.execute("/member", 1, param4);
				List<MemberDto> list1 = (List<MemberDto>) result5.get("result");
				list1.stream().forEach((dto) -> {System.out.println(dto);});
			
				break;
				
			case 22 :
				Map<String,Object> manager22param = new HashMap();
				manager22param.put("sid", sid);
				
				System.out.print("찾을 사용자 id: ");
				String user_id = sc.next();
				
				manager22param.put("user_id", user_id);
				
				Map<String, Object> manager22result = controller.execute("/member", 2, manager22param);
				
				MemberDto manager22mdto = (MemberDto) manager22result.get("result");
				
				System.out.printf(" user id: %s \n user name: %s \n user address: %s \n", manager22mdto.getId(), manager22mdto.getusername(), manager22mdto.getAdr_addr());
				
				
				
				
//				List<MemberDto> manager22list = (List<MemberDto>) manager22result.get("result");
//				manager22list.stream().forEach((dto) -> {System.out.println(dto);});
				break;
				
				
			case 31 :
				Map<String, Object> result6 = controller.execute("/order", 1, null);
				List<OrderDto> list2 = (List<OrderDto>) result6.get("result");
				list2.stream().forEach((dto) -> {System.out.println(dto);});
				break;
				
				
				
			case 32:
				System.out.print("주문 번호 입력 : ");
				String order_id = sc.next();
				Map<String,Object> param3 = new HashMap();
				
				param3.put("sid", sid);
				param3.put("order_id", order_id);
				
				
				Map<String, Object> result7 = controller.execute("/order", 2, param3);
				OrderDto dto = (OrderDto) result7.get("result");
				System.out.println(dto.toString());
				break;
				
			case 33 :
				System.out.print("삭제할 주문번호 입력 : ");
				String order_id1 = sc.next();

				
				Map<String,Object> param5 = new HashMap();
				
				param5.put("order_id1", order_id1);
				param5.put("role", role);
				
				Map<String,Object> result8 = controller.execute("/order",5,param5);
				Boolean isDelete = (Boolean)result8.get("result");
				if(isDelete==true)
					System.out.println("[INFO] 상품 삭제 완료!");
				break;
				
			case 0 : 
				Map<String,Object> manager0param = new HashMap();
				manager0param.put("sid", sid);
				controller.execute("/member", 7, manager0param);
				return ;
				
			}
			
		}
	}
	
}

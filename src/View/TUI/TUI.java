package View.TUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.Common.Dto.MemberDto;
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
		
		// 로그인 성공!!
		Map<String,Object> param = new HashMap();
		param.put("id", id);
		param.put("pw", pw);
		
		Map<String,Object> result = controller.execute("/member", 5, param);
		String sid = (String)result.get("sid");
		String role = (String)result.get("role");
		if(sid != null)
		{
			this.sid = sid;
			this.id = id;
			this.role = role;
		}
		
		
		//임의 지울것
		if(role.equals("Role_Member"))
			관리자Menu();
		else if(role.equals("Role_user"))
			회원Menu();
		else
			System.out.println("잘못된 접근입니다");
	}
	
	public void 관리자Menu() {
		while (true) {
			System.out.println("--------------------------");
			System.out.println("관리자메뉴");
			System.out.println("--------------------------");
			System.out.println("[상품]			[회원]			[주문]");
			System.out.println("1 상품조회하기		5 회원 전체조회		6 주문 전체조회"	);
			System.out.println("2 상품추가하기					    7 주문 단건조회"	);
			System.out.println("3 상품수정하기		 				8 주문 완료삭제	"	);
			System.out.println("4 상품삭제하기									"	);	
			System.out.println("9 이전으로");
			System.out.println("10로그아웃");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch(num)
			{
			case 1:
				Map<String, Object> result = controller.execute("/product", 1, null);
				List<ProdDto> list = (List<ProdDto>) result.get("result");
				list.stream().forEach((dto) -> {System.out.println(dto);});
				break;
			case 2:
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
			case 3:
				
				System.out.print("상품코드 상품명 재고량 상품가격 입력 : ");
				int product_code1 = sc.nextInt();
				String product_name1 = sc.next();
				int amount1 = sc.nextInt();
				int prod_price1 = sc.nextInt();
				
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
				
			case 4 :
				System.out.print("상품코드 상품명 재고량 상품가격 입력 : ");
				int product_code2 = sc.nextInt();

				
				Map<String,Object> param2 = new HashMap();
				
				param2.put("product_code", product_code2);
				param2.put("sid", sid);
				
				Map<String,Object> result4 = controller.execute("/product",5,param2);
				Boolean isDeleted = (Boolean)result4.get("result");
				if(isDeleted==true)
					System.out.println("[INFO] 상품 삭제 완료!");
				break;
				
			case 5 :
				Map<String, Object> result5 = controller.execute("/member", 1, null);
				List<MemberDto> list1 = (List<MemberDto>) result5.get("result");
				list1.stream().forEach((dto) -> {System.out.println(dto);});
			
				break;
				
			case 6 :
				
				break;
			case 7:
				// 대여하기
				int req_bookcode = sc.nextInt();
				String userid = sc.next();
				Map<String,Object> lend_param = new HashMap();
				lend_param.put("bookcode", req_bookcode);
				lend_param.put("id", userid);
				lend_param.put("sid", sid);
				
				Map<String,Object> result7 = controller.execute("/lend", 2, lend_param);
				Boolean isLend = (Boolean)result7.get("result");
				if(isLend == true)
				{
					System.out.println("[INFO] 대여 완료!");
				}
				break;
				
			case 10 : 
				return ;
				
			}
			
		}
	}
	
}

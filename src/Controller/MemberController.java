package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.MemberService;
import Domain.Common.Service.MemberServiceImpl;

public class MemberController implements SubController{


	 private MemberService service;
	 
	 
	 public MemberController(){ service = MemberServiceImpl.getInstance(); }


	// [CRUD]
	// [ 1 Select , 2 Insert , 3 Update , 4 Delete] 5 로그인, 6 로그아웃
	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {

		// 회원 전체 조회
		if (serviceNo == 1) {
			// 1 파라미터 추출(생략)
			String sid = (String) param.get("sid");
			// 2 입력값 검증(생략)

			// 3 서비스 실행(서비스모듈작업 이후 처리)
			List<MemberDto> list = null;
			try {
				list =  service.memberSearch(sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4 View로 전달
			System.out.println("Member_Select Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", list);
			return result;


			// 회원 단건조회
		} else if (serviceNo == 2) {
			// 1 파라미터 추출(생략)
			String sid = (String) param.get("sid");
			String user_id = (String) param.get("user_id");

//			System.out.println("Flag!! MemberController62: " + sid + " / " + user_id);
			
			// 2 입력값 검증(생략)
			if (user_id == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행(서비스모듈작업 이후 처리)

			MemberDto mdto = null;
//			List<MemberDto> list = null;
			
			try {
				mdto = service.memberSearchOne(sid, user_id);
				
//				System.out.println("Flag!! MemberController67: " + mdto);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4 View로 전달
//			System.out.println("Member_Select Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", mdto);
			return result;
			

			
			
			// 회원가입
		} else if (serviceNo == 3) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String username = (String) param.get("username");
			String adr_addr = (String) param.get("adr_addr");
			String role = (String) param.get("role");
			// 2 입력값 검증
			if (id == null || pw == null || username == null || role == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행
			MemberDto dto = new MemberDto(id, pw, username, adr_addr, role);
			System.out.println("Dto : " + dto);
			Boolean rValue = false;
			try {
				rValue =  service.memberJoin(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 4 View로 전달
			System.out.println("Member_Insert Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;

			// 회원수정
		} else if (serviceNo == 4) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String username = (String) param.get("username");
			String adr_addr = (String) param.get("adr_addr");
			String role = (String) param.get("role");
			String sid = (String) param.get("sid");
			// 2 입력값 검증
			if (id == null || pw == null || username == null || role == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행
			MemberDto dto = new MemberDto(id, pw, username, adr_addr, role);
			System.out.println("Dto : " + dto);

			Boolean rValue = false;
			try {
				rValue = service.memberUpdate(dto, sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4 View로 전달
			System.out.println("Member_Update Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;

			// 회원 삭제
		} else if (serviceNo == 5) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String sid = (String) param.get("sid");

			// 2 입력값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행

			Boolean rValue = false;
			try {
				rValue = service.memberDelete(id, sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4 View로 전달
			System.out.println("Member_Delete Block!");
			Map<String, Object> result = new HashMap();
			result.put("result", rValue);
			return result;

			// 로그인
		} else if (serviceNo == 6) {
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			MemberDto dto = new MemberDto(id, pw, null, null, null);
			Map<String, Object> result = new HashMap();
			try {
				result = service.login(id, pw);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;                                                                                     
			// 로그아웃
		} else if (serviceNo == 7) {

			String sid = (String) param.get("sid");

			if (sid == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}

			try {
				service.logout(sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}
}
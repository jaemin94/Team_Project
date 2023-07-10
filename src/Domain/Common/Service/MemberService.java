package Domain.Common.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Service.Auth.Session;

public class MemberService {

	
	//세션정보저장
	public Map<String,Session> sessionMap;
	
	private MemberDao dao;

	
	
	//싱글톤
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance==null)
			instance = new MemberService();
		return instance;
	}
	//
	
	public MemberService() {
		dao=MemberDao.getInstance();
		sessionMap=new HashMap();
	}
	
	//회원 가입하기
	public boolean memberJoin(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if(result>0)
			return true;
		return false;
	}
	
	
	public List<MemberDto> memberSearch(String sid) throws Exception{
		
		String role = sid;
		
		if(role.equals("Role_Member"))		
			return dao.select();
		return null;
	}
	
	public MemberDto memberSearchOne(String sid,String id) throws Exception{
		
			String role = sid;
            if(role.equals("Role_user"))		
			return dao.select(id);
		
		return null;
	}	
	
	
	 
	public MemberDto memberSearch(String id,String sid) throws Exception {
		Session session = sessionMap.get(sid);
		
		if(session!=null && session.getId().equals(id))
			return dao.select(id);
		
		return null;
	}
	
	
	//회원 수정하기 -- 본인확인
	public boolean memberUpdate(MemberDto dto,String sid) throws Exception{
		
		Session session = sessionMap.get(sid);
		if(session!=null && session.getId().equals(dto.getId()))
		{
			int result = dao.update(dto);
			if(result>0)
				return true;
		}
		
		
		return false;
	}	
	
	//회원 삭제하기
	public boolean memberDelete(String id,String sid) throws Exception{
		
		Session session = sessionMap.get(sid);
		if(session!=null && session.getId().equals(id))
		{
			int result = dao.delete(id);
			if(result>0)
				return true;
		}

		return false;
	}
	
	
	//로그인
	public Map<String, Object> login(String id, String pw) throws Exception{
		//1 ID/PW 체크 ->Dao 전달받은 id와 일치하는 정보를 가져와서 Pw일치 확인
		MemberDto dbDto = dao.select(id);
		if(!id.equals(dbDto.getId())) {
			System.out.println("[ERROR] Login Fail... 아이디가 일치하지 않습니다");
			return null;
		}
		if(!pw.equals(dbDto.getPw())) {
			System.out.println("[ERROR] Login Fail... 패스워드가 일치하지 않습니다");
			return null;
		}
		//2 사용자에대한 정보(Session)을 MemberService에 저장
		String sid=UUID.randomUUID().toString();
		Session session = new Session(sid,dbDto.getId(),dbDto.getRole(), dbDto.getAdr_addr());
		sessionMap.put(sid, session);
		
		//3 세션에 대한정보를 클라이언트가 접근할수 있도록하는 세션구별Id(Session Cookie) 전달
		Map<String,Object> result = new HashMap();
		result.put("sid", sid);
		result.put("role", dbDto.getRole());
		
		return result;
	}
	
	//로그아웃
	public void logout(String sid) {
		sessionMap.remove(sid);

	}
	

	//역할반환함수 
public String getRole(String sid) {
		
//		System.out.println("Flag!! MemberService149: " + sid);
//		System.out.println("Flag!! MemberService150: " + sessionMap.get(sid));
		Session session = sessionMap.get(sid);
		System.out.println("getRole's Session : " + session);
		if(session!=null) {
			return session.getRole();
			}
		
		return null;
	
	}

}

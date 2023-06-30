package Tests.DaoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Domain.Common.Dao.AddrDao;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.OrderDao;
import Domain.Common.Dto.AddrDto;
import Domain.Common.Dto.MemberDto;
import Domain.Common.Dto.OrderDto;

public class DaoTests {

	@Test
	public void MemberDaoTests1() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.insert(new MemberDto("user1","1234","홍길동",null,"Role_user"));
		assertEquals(1,result); // 기대값, 실제값
	}
	@Test
	public void MemberDaoTests2() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		
		
		int result = dao.update(new MemberDto("1234","홍길동",null,"Role_user","user1"));
		assertEquals(1,result); // 기대값, 실제값
	}

	@Test
	public void OrderDaoTests1() {
		OrderDao dao = new OrderDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.insert(new OrderDto("홍길동",null,0,"청바지",null,10,null,5));
		assertEquals(1,result); // 기대값, 실제값
	}
	
	@Test
	public void AddrDaoTests1() {
		AddrDao dao = new AddrDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.insert(new AddrDto("대구 북구",null,"홍길동"));
		assertEquals(1,result); // 기대값, 실제값
	}
}

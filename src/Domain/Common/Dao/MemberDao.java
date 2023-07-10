package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.MemberDto;

public interface MemberDao {

	// CRUD
	int insert(MemberDto dto);

	List<MemberDto> select();

	MemberDto select(String id);

	int update(MemberDto dto);

	int delete(String id);

}
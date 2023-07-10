package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.ProdDto;

public interface ProdDao {

	List<ProdDto> select();

	ProdDto select(int product_code) throws Exception;

	int insert(ProdDto dto);

	int update(ProdDto dto);

	int delete(int code);

}
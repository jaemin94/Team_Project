package Domain.Common.Dao;

import java.util.List;

import Domain.Common.Dto.OrderDto;

public interface OrderDao {

	List<OrderDto> select();

	OrderDto select(String order_id);

	int insert(OrderDto dto);

	int update(OrderDto dto);

	int delete(String order_id);

}
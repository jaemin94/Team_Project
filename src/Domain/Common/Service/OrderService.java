package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.OrderDto;

public interface OrderService {

	//		
	boolean reqOrder(String id, int product_code, int odr_amount) throws Exception;

	// 주문 전체확인
	List<OrderDto> getOrder() throws Exception;

	// 건별 주문 확인
	OrderDto getOrder(String order_id);

	// 주문하기
	boolean addOrder(OrderDto dto, String login_sid);

	// 주문정보 수정
	boolean updateOrder(OrderDto dto, String login_sid);

	// 주문 완료 및 취소 처리
	boolean removeOrder(String sid, String order_id);

}
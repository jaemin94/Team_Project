package Domain.Common.Service;

import java.util.List;

import Domain.Common.Dto.ProdDto;

public interface ProductService {

	//+reqAllProd(String sid) : List<ProdDto>
	List<ProdDto> reqAllProd() throws Exception;

	//+ reqProd(String sid, int product_code) : boolean
	ProdDto reqProd(int product_code) throws Exception;

	//+ addProd(String sid, int product_code, String product_name): boolean
	boolean addProd(String id, ProdDto dto) throws Exception;

	//+updateProd(String sid, int prodcuct_code) : boolean
	boolean updateProd(String id, ProdDto dto) throws Exception;

	boolean updateProdAmount(int product_code, ProdDto dto) throws Exception;

	//+romoveProd(String sid, int product_code) : boolean
	boolean removeProd(String sid, int product_code) throws Exception;

}
package com.sudhir.mq.services;

import com.sudhir.mq.DTO.OutputResponseDTO;
import com.sudhir.mq.DTO.ProductDTO;

public interface ProductMasterService {

	public OutputResponseDTO addProducts(ProductDTO productDTO);
	
	public OutputResponseDTO getProducts();
	
	public OutputResponseDTO getProductById(long productId);
}

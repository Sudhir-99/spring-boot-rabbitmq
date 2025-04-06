package com.sudhir.mq.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.mq.DTO.OutputResponseDTO;
import com.sudhir.mq.DTO.ProductDTO;
import com.sudhir.mq.entity.ProductMaster;
import com.sudhir.mq.repository.ProductMasterRepository;

@Service
public class ProductMasterServicesImpl implements ProductMasterService{
	
	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Override
	public OutputResponseDTO addProducts(ProductDTO productDTO) {
		try {
			ProductMaster pm= new ProductMaster();
			pm.setProductName(productDTO.getProductName());
			pm.setProductPrice(productDTO.getProductPrice());
			pm.setProductQty(productDTO.getProductQty());
			pm.setProductType(productDTO.getProductType());
			pm.setProductStatus(true);
			productMasterRepository.save(pm);
			return new OutputResponseDTO(true,pm,"Products Added","200");
		} catch (Exception e) {
			e.printStackTrace();
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

	@Override
	public OutputResponseDTO getProducts() {
		try {
			return new OutputResponseDTO(true,productMasterRepository.findAll(),"Products List","200");
		} catch (Exception e) {
			e.printStackTrace();
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

	@Override
	public OutputResponseDTO getProductById(long productId) {
		try {
			return new OutputResponseDTO(true,productMasterRepository.findById(productId),"Product Details","200");
		} catch (Exception e) {
			e.printStackTrace();
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

}

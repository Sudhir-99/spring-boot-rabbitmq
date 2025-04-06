package com.sudhir.mq.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.sudhir.mq.DTO.ProductDTO;
import com.sudhir.mq.entity.ProductMaster;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.mq.DTO.OrderDTO;
import com.sudhir.mq.DTO.OutputResponseDTO;
import com.sudhir.mq.config.MQConfig;
import com.sudhir.mq.entity.OrderMaster;
import com.sudhir.mq.repository.OrderMasterRepository;

@Service
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService{
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private OrderDetailsDTOMapperService orderDetailsDTOMapperService;

	@Override
	public OutputResponseDTO addOrder(OrderDTO orderDTO) {
		try {
			OrderMaster orderMaster = new OrderMaster();
			orderMaster.setOrderDate(new Date());
			orderMaster.setProducts(convertOrderDTOToProductMasters(orderDTO));
			orderMaster=orderMasterRepository.save(orderMaster);
			log.info("OrderMaster : {}",orderMaster);
			template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, orderMaster);
			return new OutputResponseDTO(true,orderMaster,"Order Added","200");
		} catch (Exception e) {
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

	public static List<ProductMaster> convertOrderDTOToProductMasters(OrderDTO orderDTO) {
		if (orderDTO == null || orderDTO.getProducts() == null) {
			return List.of();
		}

		return orderDTO.getProducts().stream()
				.map(OrderMasterServiceImpl::convertProductDTOToProductMaster)
				.collect(Collectors.toList());
	}

	private static ProductMaster convertProductDTOToProductMaster(ProductDTO productDTO) {
		if (productDTO == null) {
			return null;
		}

		return new ProductMaster(
				null,
				productDTO.getProductName(),
				productDTO.getProductQty(),
				productDTO.getProductPrice(),
				productDTO.getProductType(),
				productDTO.isProductStatus(),
				null
		);
	}

	@Override
	public OutputResponseDTO getAllOrders() {
		try {
			return new OutputResponseDTO(true,orderMasterRepository.findAll(),"All Orders Details","200");
		} catch (Exception e) {
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

	@Override 
	public OutputResponseDTO getOrderById(long orderId) {
		try {
			template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, orderDetailsDTOMapperService.getOrderDetails(orderId).get(0));
			return new OutputResponseDTO(true,orderMasterRepository.findById(orderId),"Order Details","200");
		} catch (Exception e) {
			return new OutputResponseDTO(false,"",e.getMessage(),"500");
		}
	}

}

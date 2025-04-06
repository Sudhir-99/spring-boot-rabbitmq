package com.sudhir.mq.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.mq.DTO.OrderDetailsDTO;
import com.sudhir.mq.entity.OrderMaster;
import com.sudhir.mq.repository.OrderMasterRepository;

@Service
public class OrderDetailsDTOMapperService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	
	public List<OrderDetailsDTO> getOrderDetails(long orderId){
		return orderMasterRepository.findById(orderId).stream().map(this::convertToOrderDetailsDTO).collect(Collectors.toList());
	}
	
	private OrderDetailsDTO convertToOrderDetailsDTO(OrderMaster order) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		OrderDetailsDTO orderDetails = modelMapper.map(order, OrderDetailsDTO.class);
		return orderDetails;
	}
	
	
	
}

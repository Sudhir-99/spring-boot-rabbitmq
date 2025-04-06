package com.sudhir.mq.services;

import com.sudhir.mq.DTO.OrderDTO;
import com.sudhir.mq.DTO.OutputResponseDTO;

public interface OrderMasterService {
	
	public OutputResponseDTO addOrder(OrderDTO orderDTO);
	
	public OutputResponseDTO getAllOrders();
	
	public OutputResponseDTO getOrderById(long orderId);

}

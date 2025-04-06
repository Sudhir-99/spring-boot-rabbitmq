package com.sudhir.mq.controller;

import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.mq.DTO.OrderDTO;
import com.sudhir.mq.DTO.OutputResponseDTO;
import com.sudhir.mq.services.OrderMasterService;

@RestController
@RequestMapping("/order")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(This.class);
	
	@Autowired
	private OrderMasterService orderMasterService;
	
	@PostMapping("/add")
	public ResponseEntity<OutputResponseDTO> addOrder(@RequestBody OrderDTO orderDTO){
		logger.info("OrderController - addOrder called");
		return ResponseEntity.ok().body(orderMasterService.addOrder(orderDTO));
	}
	
	@GetMapping("/")
	public ResponseEntity<OutputResponseDTO> getAllOrders(){
		logger.info("OrderController - getAllOrders called");
		return ResponseEntity.ok().body(orderMasterService.getAllOrders());
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OutputResponseDTO> getOrderById(@PathVariable Long orderId){
		logger.info("OrderController - getOrderById called");
		return ResponseEntity.ok().body(orderMasterService.getOrderById(orderId));
	}
	
}

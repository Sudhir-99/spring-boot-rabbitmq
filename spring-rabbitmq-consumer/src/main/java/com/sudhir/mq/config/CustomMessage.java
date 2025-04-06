package com.sudhir.mq.config;

import java.util.Date;
import java.util.List;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {

	private Long orderId;
	private Date orderDate;
	private List<Object> products;
	
	@Override
	public String toString() {
		return "{orderId=" + orderId + ", orderDate=" + orderDate + ", products=" + products + "}";
	}

}
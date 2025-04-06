package com.sudhir.mq.DTO;

import java.util.Date;
import java.util.List;

import com.sudhir.mq.entity.ProductMaster;

import lombok.Data;

@Data
public class OrderDetailsDTO {

	private Long orderId;
	private Date orderDate;
	private List<ProductMaster> products;
}

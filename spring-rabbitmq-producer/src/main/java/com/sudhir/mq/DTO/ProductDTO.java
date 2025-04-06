package com.sudhir.mq.DTO;

import java.util.List;

import com.sudhir.mq.entity.OrderMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	private String productName;
	private long productQty;
	private double productPrice;
	private String productType;
	private boolean productStatus;
}

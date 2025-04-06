package com.sudhir.mq.DTO;

import java.util.List;

import com.sudhir.mq.entity.ProductMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {

	private List<ProductDTO> products;
}

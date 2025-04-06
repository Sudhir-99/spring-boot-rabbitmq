package com.sudhir.mq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.mq.DTO.OutputResponseDTO;
import com.sudhir.mq.DTO.ProductDTO;
import com.sudhir.mq.repository.ProductMasterRepository;
import com.sudhir.mq.services.ProductMasterService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(This.class);

	@Autowired
	private ProductMasterService productMasterService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<OutputResponseDTO> addProducts(@RequestBody ProductDTO productDTO){
		logger.info("ProductController - addProduct Called");
		return ResponseEntity.ok().body(productMasterService.addProducts(productDTO));
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<OutputResponseDTO> getProducts(){
		logger.info("ProductController - getProducts called");
		return ResponseEntity.ok().body(productMasterService.getProducts());
	}
	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<OutputResponseDTO> getProductById(@PathVariable long productId){
		logger.info("ProductController - getProductById called");
		return ResponseEntity.ok().body(productMasterService.getProductById(productId));
	}
}

package com.sudhir.mq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.mq.entity.OrderMaster;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long>{

}

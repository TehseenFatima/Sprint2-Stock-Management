package com.cg.ovs.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.ovs.domain.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

	Orders findByOrderId(Integer orderId);

	List<Orders> findByCustId(Integer custId);

}

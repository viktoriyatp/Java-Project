package com.viktoriyatp.order_details;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends ListCrudRepository<OrderDetails, Integer> {

}

package com.fq.service;

import com.fq.dto.in.OrderCheckoutInDTO;
import com.fq.dto.out.OrderShowOut;
import com.fq.pojo.Order;
import com.github.pagehelper.Page;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOut getById(Long orderId);
}

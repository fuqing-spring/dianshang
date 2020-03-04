package com.fq.service;

import com.fq.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId);
}

package com.fq.service;

import com.fq.pojo.OrderHistory;

import java.util.List;

public interface OrderHistoryService {


    List<OrderHistory> getByOrderId(Long orderId);
}

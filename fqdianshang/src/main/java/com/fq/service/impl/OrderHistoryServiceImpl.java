package com.fq.service.impl;

import com.fq.mapper.OrderHistoryMapper;
import com.fq.pojo.OrderHistory;
import com.fq.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistories=orderHistoryMapper.selectByOrderId(orderId);
        return orderHistories;
    }
}

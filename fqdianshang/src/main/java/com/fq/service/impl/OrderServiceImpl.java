package com.fq.service.impl;

import com.fq.pojo.Order;
import com.fq.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return 0;
    }

    @Override
    public int insert(Order record) {
        return 0;
    }

    @Override
    public int insertSelective(Order record) {
        return 0;
    }

    @Override
    public Order selectByPrimaryKey(Long orderId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return 0;
    }
}

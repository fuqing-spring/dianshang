package com.fq.service.impl;

import com.fq.pojo.OrderHistory;
import com.fq.service.OrderHistoryService;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Override
    public int deleteByPrimaryKey(Long orderHistoryId) {
        return 0;
    }

    @Override
    public int insert(OrderHistory record) {
        return 0;
    }

    @Override
    public int insertSelective(OrderHistory record) {
        return 0;
    }

    @Override
    public OrderHistory selectByPrimaryKey(Long orderHistoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderHistory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(OrderHistory record) {
        return 0;
    }
}

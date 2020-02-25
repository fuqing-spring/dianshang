package com.fq.service.impl;

import com.fq.pojo.Order;
import com.fq.service.ProductDeailService;

public class ProductDeailServiceImpl implements ProductDeailService {
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

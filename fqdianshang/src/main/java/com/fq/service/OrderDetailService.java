package com.fq.service;

import com.fq.pojo.OrderDetail;

public interface OrderDetailService {
    int deleteByPrimaryKey(Long orderId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWith(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}

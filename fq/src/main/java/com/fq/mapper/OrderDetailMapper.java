package com.fq.mapper;

import com.fq.pojo.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWith(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}

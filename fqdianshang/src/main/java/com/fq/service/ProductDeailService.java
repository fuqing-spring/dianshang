package com.fq.service;

import com.fq.pojo.Order;
import com.fq.pojo.ProductDetail;

public interface ProductDeailService {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    int updateByPrimaryKey(Order record);
}

package com.fq.service.impl;

import com.fq.pojo.Product;
import com.fq.service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return 0;
    }

    @Override
    public int insert(Product record) {
        return 0;
    }

    @Override
    public int insertSelective(Product record) {
        return 0;
    }

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }
}

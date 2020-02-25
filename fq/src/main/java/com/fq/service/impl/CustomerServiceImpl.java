package com.fq.service.impl;

import com.fq.pojo.Customer;
import com.fq.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public int deleteByPrimaryKey(Integer customerId) {
        return 0;
    }

    @Override
    public int insert(Customer record) {
        return 0;
    }

    @Override
    public int insertSelective(Customer record) {
        return 0;
    }

    @Override
    public Customer selectByPrimaryKey(Integer customerId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return 0;
    }
}

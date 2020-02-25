package com.fq.service;

import com.fq.pojo.Address;

public interface AddressService {
    //根据Id删除
    int deleteByPrimaryKey(Integer addressId);
    //查询
    int insert(Address address);
    //查询
    int insertSelective(Address address);
    Address selectByPrimaryKey(Integer addressId);
    int updateByPrimaryKeySelective(Address address);
    int updateByPrimaryKey(Address address);
}

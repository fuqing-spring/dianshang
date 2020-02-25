package com.fq.mapper;

import com.fq.pojo.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper {
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

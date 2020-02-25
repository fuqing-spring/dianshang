package com.fq.service;

import com.fq.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorService {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator rrecord);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator getByUsername(@Param("username") String userName);
}

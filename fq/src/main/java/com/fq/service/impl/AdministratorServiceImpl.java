package com.fq.service.impl;

import com.fq.pojo.Administrator;
import com.fq.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {
    @Override
    public int deleteByPrimaryKey(Integer administratorId) {
        return 0;
    }

    @Override
    public int insert(Administrator record) {
        return 0;
    }

    @Override
    public int insertSelective(Administrator rrecord) {
        return 0;
    }

    @Override
    public Administrator selectByPrimaryKey(Integer administratorId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Administrator record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Administrator record) {
        return 0;
    }

    @Override
    public Administrator getByUsername(String userName) {
        return null;
    }
}

package com.fq.service.impl;

import com.fq.mapper.AdministratorMapper;
import com.fq.pojo.Administrator;
import com.fq.service.AdministratorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorMapper administratorMapper;

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
        return administratorMapper.getByUsername(userName);
    }

    @Override
    public Administrator getById(Integer administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> page=administratorMapper.getList();
        return page;
    }
}

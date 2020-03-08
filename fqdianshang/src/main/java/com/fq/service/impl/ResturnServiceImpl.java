package com.fq.service.impl;

import com.fq.mapper.ReturnMapper;
import com.fq.pojo.Return;
import com.fq.service.ResturnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResturnServiceImpl implements ResturnService {
    @Autowired
    ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId=aReturn.getReturnId();
        return returnId;
    }

    @Override
    public Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page=returnMapper.selectPageByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        return returnMapper.selectByPrimaryKey(returnId);
    }
}

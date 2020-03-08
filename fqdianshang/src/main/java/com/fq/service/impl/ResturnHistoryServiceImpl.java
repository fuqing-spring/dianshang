package com.fq.service.impl;

import com.fq.mapper.ResturnHistoryMapper;
import com.fq.pojo.ReturnHistory;
import com.fq.service.ResturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResturnHistoryServiceImpl implements ResturnHistoryService {
    @Autowired
    ResturnHistoryMapper returnMapper;
    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        return returnMapper.selectByReturnId(returnId);
    }
}

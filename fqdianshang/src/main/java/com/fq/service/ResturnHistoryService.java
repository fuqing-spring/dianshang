package com.fq.service;

import com.fq.pojo.ReturnHistory;

import java.util.List;

public interface ResturnHistoryService {


    List<ReturnHistory> getByReturnId(Integer returnId);
}

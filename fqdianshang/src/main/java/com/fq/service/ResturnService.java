package com.fq.service;

import com.fq.pojo.Return;
import com.github.pagehelper.Page;

public interface ResturnService {

    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}

package com.fq.mapper;

import com.fq.pojo.Product;
import com.fq.pojo.ReturnHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResturnHistoryMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<ReturnHistory> selectByReturnId(@Param("returnId") Integer returnId);
}

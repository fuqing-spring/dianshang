package com.fq.mapper;

import com.fq.pojo.ProductDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductDetail record);



    int updateByPrimaryKey(ProductDetail record);

    void batchDelete(List<Integer> productIds);
}

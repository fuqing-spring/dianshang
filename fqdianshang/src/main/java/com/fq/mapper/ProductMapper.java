package com.fq.mapper;

import com.fq.dto.out.ProductListOut;
import com.fq.pojo.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    Page<ProductListOut> search();

    Product selectByPrimaryKey(Integer productId);

    void insertSelective(Product product);

    void UPdateByPrimaryKesSelective(Product product);

    void deleteByPrimaryKey(Integer productId);

    void batchDelete(List<Integer> productIds);
}

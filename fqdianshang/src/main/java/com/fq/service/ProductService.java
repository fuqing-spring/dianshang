package com.fq.service;

import com.fq.dto.in.ProductCreateInDTO;
import com.fq.dto.in.ProductUpdateInDTO;
import com.fq.dto.out.ProductListOut;
import com.fq.dto.out.ProductShowOut;
import com.fq.pojo.Product;
import com.github.pagehelper.Page;

import java.util.List;


public interface ProductService {
    Page<ProductListOut> search(Integer pageNum);

    ProductShowOut getShowById(Integer productId);

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);

    static Product getById(Integer productId);
}

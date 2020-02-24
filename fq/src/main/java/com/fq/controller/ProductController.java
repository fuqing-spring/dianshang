package com.fq.controller;

import com.fq.dto.out.PageOut;
import com.fq.dto.out.ProductListOut;
import com.fq.dto.out.ProductShowOut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/search")
    public PageOut<ProductListOut> search(
            @RequestParam(required = false, defaultValue = "0") Integer sortType,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum
    ){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOut getById(
            Integer productId
    ){
        return null;
    }
}

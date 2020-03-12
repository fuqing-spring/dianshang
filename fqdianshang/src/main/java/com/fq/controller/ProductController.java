package com.fq.controller;

import com.fq.dto.in.ProductCreateInDTO;
import com.fq.dto.in.ProductUpdateInDTO;
import com.fq.dto.out.PageOut;
import com.fq.dto.out.ProductListOut;
import com.fq.dto.out.ProductShowOut;
import com.fq.service.ProductService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/search")
    public PageOut<ProductListOut> search(@RequestParam(required = false, defaultValue = "0") Integer sortType,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<ProductListOut> page=productService.search(pageNum);

        PageOut<ProductListOut> pageOut=new PageOut<>();
        pageOut.setTotal((int) page.getTotal());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setList(page);
        return pageOut;
    }

    @GetMapping("/getById")
    public ProductShowOut getById(@RequestParam Integer productId){
    ProductShowOut productShowOut = productService.getById(productId);
        return productShowOut;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId)
    {
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){

        productService.batchDelete(productIds);
    }

}

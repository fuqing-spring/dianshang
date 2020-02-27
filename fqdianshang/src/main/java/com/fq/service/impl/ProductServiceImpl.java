package com.fq.service.impl;

import com.alibaba.fastjson.JSON;
import com.fq.dto.in.ProductCreateInDTO;
import com.fq.dto.in.ProductUpdateInDTO;
import com.fq.dto.out.ProductListOut;
import com.fq.dto.out.ProductShowOut;
import com.fq.mapper.ProductDetailMapper;
import com.fq.mapper.ProductMapper;
import com.fq.pojo.Product;
import com.fq.pojo.ProductDetail;
import com.fq.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductDetailMapper productDetailMapper;

    @Override
    public Page<ProductListOut> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOut> page=productMapper.search();
        return page;
    }

    @Override
    public ProductShowOut getById(Integer productId) {
        Product product =productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail=productDetailMapper.selectByPrimaryKey(productId);
       ProductShowOut productShowOut=new ProductShowOut();
       productShowOut.setProductId(productId);
       productShowOut.setProductCode(product.getProductCode());
       productShowOut.setProductName(product.getProductName());
       productShowOut.setPrice(product.getPrice());
       productShowOut.setDiscount(product.getDiscount());
       productShowOut.setStatus(product.getStatus());
       productShowOut.setMainPicUrl(product.getMainPicUrl());
       productShowOut.setRewordPoints(product.getRewordPoints());
       productShowOut.setSortOrder(product.getSortOrder());
       productShowOut.setStockQuantity(product.getQuantity());
       productShowOut.setDescription(productDetail.getDescription());
       String otherPicUrlsJson =productDetail.getOtherPicUrls();
        List<String> otherPicUrls= com.alibaba.fastjson.JSON.parseArray(otherPicUrlsJson, String.class);
       productShowOut.setOtherPicUrls(otherPicUrls);
        return productShowOut;
    }

    @Override
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {
        Product product=new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStokQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        String description=productCreateInDTO.getDescription();
        String productAbstract=description.substring(0,Math.min(100,description.length()));
        product.setProductAbstract(productAbstract);
        productMapper.insertSelective(product);
        Integer productId=product.getProductId();
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        List<String> otherPicUrls=productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.insertSelective(productDetail);
        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {
        Product product=new Product();
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStokQuantity(productUpdateInDTO.getStockQuantity());
        product.setMainPicUrl(productUpdateInDTO.getMainPicUrl());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        String description=productUpdateInDTO.getDescription();
        String productAbstract=description.substring(0,Math.min(100,description.length()));
        product.setProductAbstract(productAbstract);
        productMapper.UPdateByPrimaryKesSelective(product);
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        List<String> otherPicUrls=productUpdateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }

    @Override
    public void delete(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public void batchDelete(List<Integer> productIds) {
        productMapper.batchDelete(productIds);
        productDetailMapper.batchDelete(productIds);
    }
}

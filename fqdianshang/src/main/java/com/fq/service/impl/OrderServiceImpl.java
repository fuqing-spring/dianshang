package com.fq.service.impl;

import com.alibaba.fastjson.JSON;
import com.fq.dto.in.OrderCheckoutInDTO;
import com.fq.dto.in.OrderProductInDTO;
import com.fq.enumeration.OrderStatus;
import com.fq.mapper.OrderDetailMapper;
import com.fq.mapper.OrderMapper;
import com.fq.pojo.Address;
import com.fq.pojo.Order;
import com.fq.pojo.OrderDetail;
import com.fq.pojo.Product;
import com.fq.service.AddressService;
import com.fq.service.OrderService;
import com.fq.service.ProductService;
import com.fq.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    ProductService productService;
    @Autowired
    AddressService addressService;


    @Override
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId) {
        List<OrderProductInDTO> orderProductInDTOS=orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS =orderProductInDTOS.stream().map(orderProductInDTO -> {
            Product orderProduct=ProductService.getById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO=new OrderProductVO();
            orderProductVO.setProductId(orderProduct.getProductId());
            orderProductVO.setProductCode(orderProduct.getProductCode());
            orderProductVO.setProductName(orderProduct.getProductName());
            Integer quantity=orderProductInDTO.getQuantity();
            orderProductVO.setQuantity(quantity);
            Double unitPrice=orderProduct.getPrice()* orderProduct.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);
            Double totalPrice=unitPrice*quantity;
            orderProductVO.setTotalPrice(totalPrice);
            Integer unitRewordPoints=orderProduct.getRewordPoints();
            orderProductVO.setUnitRewordPoints(unitRewordPoints);
            Integer totalRewordPoints=unitRewordPoints * quantity;
            orderProductVO.setTotalRewordPoints(totalRewordPoints);
            return orderProductVO;
        }).collect(Collectors.toList());
        double allTotalPrice = orderProductVOS.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        int allTotalRewordPoints =orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order=new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(allTotalPrice);
        order.setRewordPoints(allTotalRewordPoints);
        Date now =new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        orderMapper.insertSelective(order);
        Long orderId=order.getOrderId();

        OrderDetail orderDetail=new OrderDetail();
         orderDetail.setOrderId(orderId);
         orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());

         orderDetail.setShipPrice(5.0);
        Address shipAddress=addressService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddres(shipAddress.getContent());

        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(allTotalPrice);
        Address invoiceAddress=addressService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAdderss(invoiceAddress.getContent());

        orderDetail.setComment(orderCheckoutInDTO.getComment());

        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));

        orderDetailMapper.insertSelective(orderDetail);
        return orderId;
    }
}

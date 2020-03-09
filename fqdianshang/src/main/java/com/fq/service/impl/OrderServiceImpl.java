package com.fq.service.impl;

import com.alibaba.fastjson.JSON;
import com.fq.dto.in.OrderCheckoutInDTO;
import com.fq.dto.in.OrderProductInDTO;
import com.fq.dto.out.OrderHistoryListOutDTO;
import com.fq.dto.out.OrderShowOut;
import com.fq.enumeration.OrderStatus;
import com.fq.mapper.OrderDetailMapper;
import com.fq.mapper.OrderMapper;
import com.fq.pojo.*;
import com.fq.service.AddressService;
import com.fq.service.OrderHistoryService;
import com.fq.service.OrderService;
import com.fq.service.ProductService;
import com.fq.vo.OrderProductVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    @Autowired
    private OrderHistoryService orderHistoryService;


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

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Order> page=orderMapper.selectByCustomerId(customerId);
        return page;
    }

    @Override
    public OrderShowOut getById(Long orderId) {
        Order order=orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail=orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOut orderShowOut=new OrderShowOut();
        orderShowOut.setOrderId(Math.toIntExact(orderId));
        orderShowOut.setStatus(order.getStatus());
        orderShowOut.setTotalPrice(order.getTotalPrice());
        orderShowOut.setRewordPoints(order.getRewordPoints());
        orderShowOut.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOut.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOut.setShipMethod(orderDetail.getShipMethod());
        orderShowOut.setShipAddress(orderDetail.getShipAddres());
        orderShowOut.setShipPrice(orderDetail.getShipPrice());
        orderShowOut.setPayMethod(orderDetail.getPayMethod());
        orderShowOut.setInvoiceAddress(orderDetail.getInvoiceAdderss());
        orderShowOut.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOut.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOut.setOrderProducts(orderProductVOS);

        List<OrderHistory> orderHistories =orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        orderShowOut.setOrderHistories(orderHistoryListOutDTOS);

        return orderShowOut;
    }
}

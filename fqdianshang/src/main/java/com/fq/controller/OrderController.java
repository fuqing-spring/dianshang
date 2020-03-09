package com.fq.controller;

import com.fq.dto.in.OrderCheckoutInDTO;
import com.fq.dto.out.OrderListOut;
import com.fq.dto.out.OrderShowOut;
import com.fq.dto.out.PageOut;
import com.fq.pojo.Order;
import com.fq.service.OrderService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO, @RequestAttribute Integer customerId){
        Long orderId=orderService.checkout(orderCheckoutInDTO,customerId);
        return orderId;
    }

    @GetMapping("/getList")
    public PageOut<OrderListOut> getMyWithPage(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestAttribute Integer customerId
    ){
        Page<Order> page=orderService.getByCustomerId(pageNum,customerId);
        List<OrderListOut> orderListOuts=page.stream().map(order -> {
            OrderListOut orderListOut=new OrderListOut();
            orderListOut.setOrderId(order.getOrderId());
            orderListOut.setStatus(order.getStatus());
            orderListOut.setTotalPrice(order.getTotalPrice());
            orderListOut.setCreateTimestamp(order.getCreateTime().getTime());
            return orderListOut;
        }).collect(Collectors.toList());
        PageOut<OrderListOut> pageOut=new PageOut<>();
        pageOut.setTotal((int) page.getTotal());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setList(orderListOuts);
        return pageOut;
    }

    @GetMapping("/getById")
    public OrderShowOut getById(
            @RequestParam Long orderId
    ){
        OrderShowOut orderShowOut=orderService.getById(orderId);
        return orderShowOut;
    }
}

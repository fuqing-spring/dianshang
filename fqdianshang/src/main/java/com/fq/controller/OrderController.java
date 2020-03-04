package com.fq.controller;

import com.fq.dto.in.OrderCheckoutInDTO;
import com.fq.dto.out.OrderListOut;
import com.fq.dto.out.OrderShowOut;
import com.fq.dto.out.PageOut;
import com.fq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getMyWithPage")
    public PageOut<OrderListOut> getMyWithPage(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            Integer customerId
    ){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOut getById(
            @RequestParam Integer orderId
    ){
        return null;
    }
}

package com.fq.controller;

import com.fq.dto.in.OrderProductIn;
import com.fq.dto.out.OrderListOut;
import com.fq.dto.out.OrderShowOut;
import com.fq.dto.out.PageOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prder")
public class OrderController {
    @PostMapping("/checkout")
    public Integer checkout(
            List<OrderProductIn> orderproducts,
            Integer customerId
    ){
        return null;
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

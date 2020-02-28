package com.fq.controller;

import com.fq.dto.in.CustomerRegisterIn;
import com.fq.dto.out.CustomerProfileOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //注册
    @PostMapping("/register")
    public Integer register(
            CustomerRegisterIn customerRegisterIn
    ){
        return null;
    }

    //登录
    @GetMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password
    ){
        return null;
    }

    @GetMapping("/getProfile")
    public CustomerProfileOut getProfile(
            Integer customerId
    ){
        return null;
    }

    //修改密码
    @PostMapping("/changePassword")
    public void changePassword(
            @RequestParam String originPwd,
            @RequestParam String newPwd,
            Integer customerId
    ){

    }

    @GetMapping("/sendPwdResetCodeToEmail")
    public void sendPwdResetCodeToEmail(
            String email
    ){

    }

    @PostMapping("/resetPwdByEmail")
    public void resetPwdByEmail(
            @RequestParam String email,
            @RequestParam String code,
            @RequestParam String newPwd
    ){

    }

    @GetMapping("/sendPwdResetCodeToMobile")
    public void sendPwdResetCodeToMobile(
            String mobile
    ){

    }

    @PostMapping("/resetPwdByMobile")
    public void resetPwdByMobile(
            @RequestParam String mobile,
            @RequestParam String code,
            @RequestParam String newPwd
    ){

    }

}

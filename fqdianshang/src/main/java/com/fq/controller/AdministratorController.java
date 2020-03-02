package com.fq.controller;

import com.fq.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administratorController")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;



}

package com.fq.service;

import com.fq.dto.in.CustomerRegisterIn;
import com.fq.pojo.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterIn customerRegisterIn);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);

    Customer getByEmail(String email);
}

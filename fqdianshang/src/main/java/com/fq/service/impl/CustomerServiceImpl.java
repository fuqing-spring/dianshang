package com.fq.service.impl;

import com.fq.dto.in.CustomerRegisterIn;
import com.fq.enumeration.CustomerStatus;
import com.fq.mapper.CustomerMapper;
import com.fq.pojo.Customer;
import com.fq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;


    @Override
    public Integer register(CustomerRegisterIn customerRegisterIn) {
        Customer customer=new Customer();
        customer.setUserName(customerRegisterIn.getUserName());
        customer.setRealName(customerRegisterIn.getRealName());
        customer.setEmail(customerRegisterIn.getEmail());
        customer.setEmailVerified(false);
        customer.setMobile(customerRegisterIn.getMobile());
        customer.setMobileVerified(false);
        customer.setNewsSubscribed(customerRegisterIn.getNewsSubscribed());
        customer.setCreateTime(new Date());
        customer.setStatus((byte) CustomerStatus.Enable.ordinal());
        customer.setRewordPoints(0);

        String password=customerRegisterIn.getPassword();
        String bcryptHashString=BCrypt.withDefaults().hashToString(12, password.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);

        customerMapper.insertSelective(customer);
        Integer customerId=customer.getCustomerId();

        return customerId;
    }

    @Override
    public Customer getByUsername(String username) {
        return customerMapper.selectByUsername(username);
    }

    @Override
    public Customer getById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerMapper.selectByEmail(email);
    }
}

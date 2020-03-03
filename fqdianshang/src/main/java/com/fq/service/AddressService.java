package com.fq.service;

import com.fq.pojo.Address;

import java.util.List;

public interface AddressService {
   

    List<Address> getByCustomerId(Integer customerId);

    Address getById(Integer addressId);

    Integer create(Address address);

    void update(Address address);

    void delete(Integer addressId);
}

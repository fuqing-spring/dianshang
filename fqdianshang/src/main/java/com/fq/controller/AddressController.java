package com.fq.controller;

import com.fq.dto.in.AddressCreateIn;
import com.fq.dto.in.AddressUpdateIn;
import com.fq.dto.out.AddresListOut;
import com.fq.dto.out.AddressShowOutDTO;
import com.fq.pojo.Address;
import com.fq.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/getCustomerAddress")
    public List<AddresListOut> getCustomerAddress(@RequestAttribute  Integer customerId){
        List<Address> addresses=addressService.getByCustomerId(customerId);

        List<AddresListOut> addresListOuts=addresses.stream().map(address ->{
            AddresListOut addresListOut=new AddresListOut();
            addresListOut.setAddressId(address.getAddressId());
            addresListOut.setTag(address.getTag());
            addresListOut.setReceiverName(address.getReceiverName());
            addresListOut.setReceiverMobile(address.getReceiverMoblie());
            addresListOut.setContent(address.getContent());
            return addresListOut;
        }).collect(Collectors.toList());
        return addresListOuts;
    }

    @PostMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId
    ){
        Address address=addressService.getById(addressId);
        AddressShowOutDTO addressShowOutDTO=new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setTag(address.getTag());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMoblie());
        addressShowOutDTO.setContent(address.getContent());
        return addressShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(
            @RequestBody AddressCreateIn addressCreateIn,@RequestAttribute Integer customerId
    ){
        Address address=new Address();
        address.setCustomerId(customerId);
        address.setTag(addressCreateIn.getTag());
        address.setReceiverName(addressCreateIn.getReceiverName());
        address.setReceiverMoblie(addressCreateIn.getReceiverMobile());
        address.setContent(addressCreateIn.getContent());
        addressService.create(address);
        Integer addressId=address.getAddressId();
        return addressId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateIn addressUpdateIn){
        Address address=new Address();
        address.setAddressId(addressUpdateIn.getAddressId());
        address.setTag(addressUpdateIn.getTag());
        address.setReceiverName(addressUpdateIn.getReceiverName());
        address.setReceiverMoblie(addressUpdateIn.getReceiverMobile());
        address.setContent(addressUpdateIn.getContent());
        addressService.update(address);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId){
        addressService.delete(addressId);
    }

}

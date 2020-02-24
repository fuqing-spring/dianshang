package com.fq.controller;

import com.fq.dto.in.AddressCreateIn;
import com.fq.dto.in.AddressUpdateIn;
import com.fq.dto.out.AddresListOut;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @GetMapping("/getMyAddresses")
    public List<AddresListOut> getMyAddresses(
            Integer customerId
    ){
        return null;
    }

    @PostMapping("/createMy")
    public Integer createMy(
            @RequestBody AddressCreateIn addressCreateInDTO,
            Integer customerId
    ){
        return null;
    }

    @PostMapping("/updateMy")
    public void updateMy(
            @RequestBody AddressUpdateIn addressUpdateInDTO
    ){

    }

}

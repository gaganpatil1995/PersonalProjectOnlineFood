package com.masai.controller;

import com.masai.entity.Address;
import com.masai.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressControl {
    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public Address saveAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("/{id}")
    public Address viewAddress(@PathVariable Integer id){
        return addressService.viewAddress(id);
    }
}

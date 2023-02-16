package com.masai.service;

import com.masai.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    public Address addAddress(Address address);
    public Address viewAddress(Integer id);

}

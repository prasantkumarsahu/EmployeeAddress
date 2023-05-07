package com.prasant.employeeaddress.controllers;

import com.prasant.employeeaddress.models.Address;
import com.prasant.employeeaddress.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }
    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @PostMapping(value = "/")
    public String createAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @PutMapping(value = "/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }
    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}

package com.prasant.employeeaddress.services;

import com.prasant.employeeaddress.models.Address;
import com.prasant.employeeaddress.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public String addAddress(Address address) {
        addressRepository.save(address);
        return "Address created!";
    }

    public String updateAddress(Long id, Address address) {
        Address oldAddress = addressRepository.findById(id).orElse(null);
        if(oldAddress != null){
            oldAddress.setCity(address.getCity());
            oldAddress.setState(address.getState());
            oldAddress.setStreet(address.getStreet());
            oldAddress.setZipcode(address.getZipcode());
            addressRepository.save(oldAddress);
            return "Address updated!";
        }
        else return "Invalid address Id!";
    }

    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return "Address deleted";
    }
}

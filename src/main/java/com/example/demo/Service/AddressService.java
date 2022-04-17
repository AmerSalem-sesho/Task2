package com.example.demo.Service;
import com.example.demo.Model.Address;
import com.example.demo.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void addNewAddress(Address address) {
        addressRepository.save(address);
    }

    public void updateAddress(long id,Address address) {

        Address temp = addressRepository.findById(id).get();
        temp.setStreet(address.getStreet());
        temp.setCity(address.getCity());
        addressRepository.save(temp);
    }

    public void deleteAddress(long id) {
        boolean exists = addressRepository.existsById(id);
        if(!exists)
            System.out.println("address not found");
        else
            addressRepository.deleteById(id);
    }
}

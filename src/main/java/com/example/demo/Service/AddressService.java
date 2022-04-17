package com.example.demo.Service;
import com.example.demo.Model.Address;
import com.example.demo.Model.Department;
import com.example.demo.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Address> pagedResult = addressRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Address>();
        }
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

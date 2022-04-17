package com.example.demo.Controller;
import com.example.demo.DTO.AddressDto;
import com.example.demo.Model.Address;
import com.example.demo.Service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @PostMapping
    public void addNewAddress (@RequestBody AddressDto addressDto){
        Address temp = modelMapper.map(addressDto,Address.class);
        addressService.addNewAddress(temp);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable  long id,@RequestBody AddressDto addressDto){
        Address temp = modelMapper.map(addressDto,Address.class);
        addressService.updateAddress(id,temp);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
    }
}

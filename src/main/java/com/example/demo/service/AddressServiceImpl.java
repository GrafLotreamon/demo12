package com.example.demo.service;


import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public void add(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address get(long id) {
        Optional<Address> res = addressRepository.findById(id);
        return res.get();
    }

    @Override
    public void delete(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void edit(Address address, long id) {
        Optional<Address> res = addressRepository.findById(id);
        res.get().setCity(address.getCity());
        res.get().setHomeNumber(address.getHomeNumber());
        res.get().setStreet(address.getStreet());
    }
}

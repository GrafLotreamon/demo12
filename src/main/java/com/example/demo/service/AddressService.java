package com.example.demo.service;

import com.example.demo.entity.Address;

import java.util.List;

public interface AddressService {

    void add(Address address);

    Address get(long id);

    void delete(long id);

    List<Address> getAll();

    void edit(Address address, long id);
}

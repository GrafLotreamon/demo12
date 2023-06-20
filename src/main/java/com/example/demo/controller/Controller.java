package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok().body(addressService.getAll());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) {
        return ResponseEntity.ok().body(addressService.get(id));
    }

    @PostMapping("/address")
    public HttpStatus createAddress(@RequestBody Address address) {
        this.addressService.add(address);
        return HttpStatus.OK;
    }

    @PutMapping("/products/{id}")
    public HttpStatus updateAddress(@PathVariable long id, @RequestBody Address address) {
        addressService.edit(address, id);
        return HttpStatus.OK;

    }

    @DeleteMapping("/address/{id}")
    public HttpStatus deleteAddress(@PathVariable long id) {
        this.addressService.delete(id);
        return HttpStatus.OK;
    }

}
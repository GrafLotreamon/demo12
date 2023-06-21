package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableMethodSecurity
public class Controller {

    private final AddressService addressService;

    public Controller(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok().body(addressService.getAll());
    }

    @GetMapping("/address/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) {
        return ResponseEntity.ok().body(addressService.get(id));
    }

    @PostMapping("/address")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus createAddress(@RequestBody Address address) {
        this.addressService.add(address);
        return HttpStatus.OK;
    }

    @PutMapping("/address/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus updateAddress(@PathVariable long id, @RequestBody Address address) {
        addressService.edit(address, id);
        return HttpStatus.OK;

    }

    @DeleteMapping("/address/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus deleteAddress(@PathVariable long id) {
        this.addressService.delete(id);
        return HttpStatus.OK;
    }
}
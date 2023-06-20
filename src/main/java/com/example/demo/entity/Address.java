package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "City")
    private String City;

    @Column(name = "Street")
    private String Street;

    @Column(name = "HomeNumber")
    private int HomeNumber;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getHomeNumber() {
        return HomeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        HomeNumber = homeNumber;
    }
}

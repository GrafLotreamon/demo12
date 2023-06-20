package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "addresses")
    @OneToMany
    private List<Address> addresses;

    public Dictionary(int id, List<Address> addresses) {
        Id = id;
        this.addresses = addresses;
    }

    public Dictionary() {
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

package com.example.day4post.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="busbooking")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String number;
    private String email;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference

    private BusBook busBook;

    public User() {
    }

    public User(int id, String firstname, String lastname, String number, String email, BusBook busBook) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.busBook = busBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BusBook getBusBook() {
        return busBook;
    }

    public void setBusBook(BusBook busBook) {
        this.busBook = busBook;
    }

    


    


    
    

    

    

}

package com.example.day4post.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class BusBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    String fromlocation;
    String tolocation;
    String departuredate;
    String returndate;
    String bustype;

    @OneToOne
    @JsonBackReference

    private User user;

    public BusBook() {
    }

    public BusBook(int id, String fromlocation, String tolocation, String departuredate, String returndate,
            String bustype, User user) {
        this.id = id;
        this.fromlocation = fromlocation;
        this.tolocation = tolocation;
        this.departuredate = departuredate;
        this.returndate = returndate;
        this.bustype = bustype;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    




    
}

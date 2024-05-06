package com.example.day4post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4post.model.BusBook;
import com.example.day4post.repository.BusBookRepo;

@Service
public class BusBookService {
    @Autowired
    BusBookRepo br;

    public BusBook createB(BusBook bus){
        return br.save(bus);
    }

    public BusBook getBusbyid(int id){
        return br.findById(id).orElse(null);
    }
    
}

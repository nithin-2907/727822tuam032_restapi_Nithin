package com.example.day4post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4post.model.BusBook;

public interface BusBookRepo extends JpaRepository<BusBook,Integer>{
    
}

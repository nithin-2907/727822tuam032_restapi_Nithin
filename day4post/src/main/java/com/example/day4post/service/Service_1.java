package com.example.day4post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day4post.model.User;
import com.example.day4post.repository.Repository;
@Service
public class Service_1
{
    @Autowired
    public Repository ab;

    public User createnewuser(@NonNull User user)
    {
        return ab.save(user);
    }


    public List<User> getAllusers()
    {
        return ab.findAll();
    }

    
    
    public Optional<User> getModelByEmail(String email)
    {
        return ab.findByEmail(email);
    }

    public User getById(int id){
        return ab.findById(id).orElse(null);
    }


    public User updateUser(@NonNull String email,@RequestBody User user)
    {
        return ab.findByEmail(email)
        .map(existingUser -> {
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setNumber(user.getNumber());
        existingUser.setEmail(user.getEmail());
        // existingUser.setPassword(user.getPassword());
        // existingUser.setFromplace(user.getFromplace());
        // existingUser.setToplace(user.getToplace());
        // existingUser.setDparturedate(user.getDparturedate());
        // existingUser.setReturndate(user.getReturndate());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ email));

    }
    public void removeUser(@NonNull Integer Id)
    {
        ab.deleteById(Id);
    }

    
}
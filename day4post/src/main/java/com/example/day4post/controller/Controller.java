package com.example.day4post.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4post.model.User;
import com.example.day4post.service.Service_1;

import lombok.NonNull;

@RestController
@RequestMapping("/api/busbook")
public class Controller
{
    

@Autowired
private  Service_1 userService;

@PostMapping("/createUser")

public ResponseEntity<User> createUser(@NonNull @RequestBody User user) {

User createdUser = userService.createnewuser(user);

return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

}

@GetMapping("getUser/{email}")


public ResponseEntity<?> getUserByEmail(@PathVariable String email)
{

Optional<User> user = userService.getModelByEmail(email);

return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

@GetMapping("getUser/{id}")
public ResponseEntity<User> getById(@PathVariable int id){
    try {
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}


@GetMapping("/getUsers")


public ResponseEntity<List<User>> getAllUsers()
{

List<User> users = userService.getAllusers();

return new ResponseEntity<>(users, HttpStatus.OK);

}

@PutMapping("updateUser/{email}")


public ResponseEntity<User> updateUser(@NonNull @PathVariable String email,@RequestBody User updateRequest)
{

User updated = userService.updateUser(email, updateRequest);

return new ResponseEntity<>(updated, HttpStatus.OK);

}

@DeleteMapping("deleteUser/{userId}")


public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}
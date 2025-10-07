package com.example.demo.service;


import com.example.demo.model.datamodel;
import com.example.demo.repository.jparepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private jparepository repo;

    public List<datamodel> getallusers(){
        return repo.findAll();
    }

    public Optional<datamodel> getuserbyid(int id){
        return repo.findById(id);
    }

    public datamodel saveuser(datamodel user){
        return repo.save(user);
    }

    public Optional<datamodel> deleteuser(int id){
        Optional<datamodel> userOptional = repo.findById(id);

        if (userOptional.isPresent()) {
            repo.deleteById(id);
        }

        return userOptional;
    }

    public String login(datamodel data) {
        String username = data.getUsername().trim();
        String password = data.getPassword().trim();

        System.out.println("Login attempt for username: " + username);

        datamodel userexistence = repo.findByUsername(username);

        if (userexistence == null) {
            return "user not found";
        }

        if (userexistence.getPassword().trim().equals(password)) {
            return "Login successful";
        } else {
            return "incorrect password";
        }
    }
}

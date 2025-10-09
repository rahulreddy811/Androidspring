package com.example.demo.controller;

import com.example.demo.model.datamodel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class usercontroller {

    @Autowired
    private UserService user;

    @GetMapping
    public List<datamodel> getallusers(){
        return user.getallusers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<datamodel> getbyid(@PathVariable int id){
        Optional<datamodel> User = user.getuserbyid(id);

        if (User.isPresent()){
            return ResponseEntity.ok(User.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public datamodel createuser(@RequestBody datamodel data){
        return user.saveuser(data);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<datamodel> updateuser(@PathVariable int id,@RequestBody datamodel data){
        Optional<datamodel> use = user.getuserbyid(id);

        if (use.isPresent()){
            data.setId(id);
            return ResponseEntity.ok(user.saveuser(data));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Optional<datamodel> deletedUser = user.deleteuser(id);
        if (deletedUser.isPresent()) {
            return ResponseEntity.ok(deletedUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody datamodel data) {
        String message = user.login(data);
        return ResponseEntity.ok(message);
    }
}

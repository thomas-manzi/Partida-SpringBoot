package com.spring.partida.controller;

import com.spring.partida.models.User;
import com.spring.partida.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController {

    private UserRepository ur;

    UserController(UserRepository userRepo){
        this.ur = userRepo;
    }

    @GetMapping
    public List findAll(){
        return ur.findAll();
    }

    @GetMapping(path = {"/{id}"} )
    public ResponseEntity findById(@PathVariable long id){
        return ur.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return ur.save(user);
    }


//    @GetMapping(value = "/addUser")
//    public String form(){ return "user/users/formUser";}
//
//    @PostMapping(value = "/addUser" )
//    public String form(User user){
//        ur.save(user);
//        return "redirect:user/addUser";
//    }
//


}

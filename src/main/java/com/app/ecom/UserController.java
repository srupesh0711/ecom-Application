package com.app.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    // http://localhost:8080/api/users
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>>getAllUsers(){
       return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUsers(@RequestBody Users users){
        userService.addUsers(users);
        return new ResponseEntity<>("SuccessFully added....",HttpStatus.CREATED);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
//        Users users = userService.getById(id);
//        if(users == null)
//            return ResponseEntity.notFound().build();
//            return ResponseEntity.ok(users);
     // return new ResponseEntity<>(userService.getById(id),HttpStatus.OK) ;
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

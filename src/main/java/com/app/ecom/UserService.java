package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<Users> usersList = new ArrayList<>();
    private Long nextId = 1L;

    public List<Users> fetchAllUsers(){
        return usersList ;
    }

    public void addUsers(Users users){
        users.setId(nextId++);
        usersList.add(users);
    }

    public Optional<Users> getById(Long id){
//        for(Users users : usersList){
//            if(users.getId().equals(id)){
//                return users;
//            }
//        }
//        return null;
        return usersList.stream()
                .filter(users -> users.getId().equals(id))
                .findFirst();
    }
}

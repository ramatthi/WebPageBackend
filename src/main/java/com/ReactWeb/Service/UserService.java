package com.ReactWeb.Service;

import com.ReactWeb.Model.Home;
import com.ReactWeb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public Mono<Home> createUser(Home home) {

        return userRepo.save(home);
     }
     
    public Mono<String> login(String email, String password) {
        return userRepo.findByEmail(email)
                .flatMap(user -> {
                    if (user.getPassword().equals(password)) {
                        return Mono.just("Login Success"); // Successful login
                    } else {
                        return Mono.just("Incorrect Password"); // Password doesn't match
                    }
                })
                .switchIfEmpty(Mono.just("Email not exists")); // Email does not exist
    }
    }









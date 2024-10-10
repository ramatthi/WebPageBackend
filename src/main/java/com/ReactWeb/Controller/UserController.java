package com.ReactWeb.Controller;

import com.ReactWeb.Model.Home;
import com.ReactWeb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public Mono<ResponseEntity<String>> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        return userService.login(email, password)
                .map(message -> ResponseEntity.ok(message)); // Send the message as response
    }



    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public Mono<Home> createUser(@RequestBody Home home){
        System.out.println(home.getMobileNumber());
        return userService.createUser(home);
    }







//    @PostMapping("/register")
//    public Mono<ResponseEntity<String>> registerUser(@RequestBody Home home) {
//        return userService.createUser(home)
//                .map(user -> ResponseEntity.ok("Registration Successful"))
//                .onErrorResume(e -> {
//                    // Handle the error, e.g., return an error response
//                    return Mono.just(ResponseEntity.badRequest().body(e.getMessage()));
//                });
//    }


}

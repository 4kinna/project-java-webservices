package com.example.projectjavawebservices.controller;


import com.example.projectjavawebservices.dto.PostDto;
import com.example.projectjavawebservices.entities.AppUser;
import com.example.projectjavawebservices.services.PostService;
import com.example.projectjavawebservices.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    //Get Specific user by id
    @GetMapping("/{id}")
    public AppUser findById(@PathVariable int id){
        return userService.findById(id);
    }

    //POST add user
    @PostMapping
    public AppUser addUser(@RequestBody AppUser user){
        return userService.addUser(user);
    }

    //PUT update existing user
    @PutMapping("/{id}")
    public AppUser updateUser(@RequestBody AppUser user, @PathVariable int id){
        return userService.updateUser(user,id);
    }

    //DELETE user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    //GET post from api
    @GetMapping("/{id}/posts")
        public List<PostDto> findByUserId(@PathVariable int id){
            return postService.findByUserId(id);
        }


}

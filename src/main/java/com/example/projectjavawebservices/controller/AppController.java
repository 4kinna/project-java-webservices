package com.example.projectjavawebservices.controller;


import com.example.projectjavawebservices.dto.Post;
import com.example.projectjavawebservices.entities.AppUser;
import com.example.projectjavawebservices.services.PostService;
import com.example.projectjavawebservices.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class AppController {

    private final UserService userService;
    private final PostService postService;

    public AppController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    //Get Specific user by id
    @PreAuthorize("hasPermission(#id, '')")
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
    @PreAuthorize("hasPermission(#id, '')")
    @PutMapping("/{id}")
    public AppUser updateUser(@RequestBody AppUser user, @PathVariable int id){
        return userService.updateUser(user,id);
    }

    //DELETE user
    @PreAuthorize("hasPermission(#id, '')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    //GET post from api
    @PreAuthorize("hasPermission(#id, '')")
    @GetMapping("/{id}/posts")
        public List<Post> findByUserId(@PathVariable int id){
            return postService.findByUserId(id);
        }


}

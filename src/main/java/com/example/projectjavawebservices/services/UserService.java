package com.example.projectjavawebservices.services;

import com.example.projectjavawebservices.entities.AppUser;
import com.example.projectjavawebservices.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //GET Specific user by id
    public AppUser findById(int id) {
        return userRepo.findById(id).orElseThrow();
    }

    //POST add user
    public AppUser addUser(AppUser user) {
        return userRepo.save(user);
    }

    //PUT update existing user
    public AppUser updateUser(AppUser user, int id) {
        AppUser existingUser = userRepo.findById(id).orElseThrow();
        existingUser.setUsername(user.getUsername());

        return userRepo.save(existingUser);
    }

    //Delete User
    public void deleteUser(int id) {
        AppUser user = userRepo.findById(id).orElseThrow();
        userRepo.delete(user);

    }
}

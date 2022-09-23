package com.example.projectjavawebservices.repo;

import com.example.projectjavawebservices.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Integer> {


    Optional<AppUser> findAppUserByUsernameIgnoreCase(String username);
}

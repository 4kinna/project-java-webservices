package com.example.projectjavawebservices.repo;

import com.example.projectjavawebservices.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Integer> {


}

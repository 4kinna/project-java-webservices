package com.example.projectjavawebservices;

import com.example.projectjavawebservices.entities.AppUser;
import com.example.projectjavawebservices.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectJavaWebservicesApplication implements CommandLineRunner {


    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjectJavaWebservicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.save(new AppUser("annika", passwordEncoder.encode("1234")));
        userRepo.findAppUserByUsernameIgnoreCase("annika").ifPresent(System.out::println);


    }
}

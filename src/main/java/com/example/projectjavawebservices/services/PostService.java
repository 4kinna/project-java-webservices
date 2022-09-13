package com.example.projectjavawebservices.services;

import com.example.projectjavawebservices.config.WebClientConfig;
import com.example.projectjavawebservices.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PostService {

    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<PostDto> findByUserId(int id) {
        return webClient
                .get()
                .uri("/posts?userId="+id)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(PostDto.class))
                .buffer()
                .blockLast();
    }
}

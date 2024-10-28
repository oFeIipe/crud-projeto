package com.example.crud_posts.controllers;


import com.example.crud_posts.domain.posts.Posts;
import com.example.crud_posts.domain.posts.PostsRepository;
import com.example.crud_posts.domain.posts.RequestPost;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")

public class PostController {

    @Autowired
    private PostsRepository repository;

    @GetMapping
    public ResponseEntity getAllPosts(){
        var allPosts = repository.findAll();
        return ResponseEntity.ok(allPosts);
    }

    @PostMapping
    public ResponseEntity createPost(@RequestBody @Valid RequestPost data){
        Posts novoPost = new Posts(data);
        repository.save(novoPost);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity editPost(@RequestBody @Valid RequestPost data){
        Optional<Posts> optionalPost = repository.findById(data.id());
        if (optionalPost.isPresent()) {
            Posts post = optionalPost.get();
            post.setConteudo(data.conteudo());
            return ResponseEntity.ok(post);
        } else {
            throw new EntityNotFoundException();
        }
    }
}

package com.gdsc.crud8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    private final PostService postService;
    @PostMapping
    public void savePost(@RequestBody PostRequest request){
        postService.save(request);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable String id){
        return postService.getPost(id);
    }
}

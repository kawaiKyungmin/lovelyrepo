package com.gdsc.crud8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {


    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private final PostRepository postRepository;


    public void save(PostRequest postRequest){
        Post post = new Post(UUID.randomUUID().toString(),
                postRequest.getTitle(),
                postRequest.getContent());
        postRepository.save(post);
    }

    public Post getPost(String id){
        return postRepository.findById(id).orElseThrow();

    }
    public List<Post> getAll(){
        return postRepository.findAll();
    }
    //jpa변경 감지

}

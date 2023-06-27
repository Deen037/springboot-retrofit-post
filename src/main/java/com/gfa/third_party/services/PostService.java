package com.gfa.third_party.services;

import com.gfa.third_party.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> fetchPosts();
}

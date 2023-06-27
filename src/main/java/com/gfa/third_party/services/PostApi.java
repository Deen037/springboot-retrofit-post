package com.gfa.third_party.services;

import com.gfa.third_party.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> fetchPosts();
}

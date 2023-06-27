package com.gfa.third_party.services.impl;

import com.gfa.third_party.model.Post;
import com.gfa.third_party.services.PostApi;
import com.gfa.third_party.services.PostService;
import com.gfa.third_party.util.RetrofitUtil;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class PostServiceImpl implements PostService {
    private Retrofit retrofit;
    private PostApi postApi;

    public PostServiceImpl() {
        retrofit = RetrofitUtil.getRetrofitInstance();
        postApi = retrofit.create(PostApi.class);
    }

    @Override
    public List<Post> fetchPosts() {
        List<Post> postResponse = new ArrayList<>();

        Call<List<Post>> fetchPostCall = postApi.fetchPosts();

        try {
            Response<List<Post>> response = fetchPostCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                postResponse = response.body();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return postResponse;
    }
}

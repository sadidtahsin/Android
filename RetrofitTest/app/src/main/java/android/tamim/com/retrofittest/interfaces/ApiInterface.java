package android.tamim.com.retrofittest.interfaces;

import android.tamim.com.retrofittest.models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("posts")
    Call<List<Posts>> getPosts();
}

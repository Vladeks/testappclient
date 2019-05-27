package com.example.testappclient.utils;

import com.example.testappclient.model.Question;
import com.example.testappclient.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    @POST("/questions")
    Call<Question> addQuestion(@Body Question question);

    @GET("/questions")
    Call<List<Question>> getQuestions();

    @GET("/questions/{id}")
    Call<Question> getQuestion(@Path("id") Long id);

    @POST("/login")
    Call<ResponseBody> login(@Body User user);

    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}

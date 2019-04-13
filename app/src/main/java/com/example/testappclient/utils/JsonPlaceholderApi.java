package com.example.testappclient.utils;

import com.example.testappclient.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface JsonPlaceholderApi {

    @POST("/questions")
    Call<Question> addQuestion(Question question);

    @GET("/questions")
    Call<List<Question>> getQuestions();

    @GET("/questions/{id}")
    Call<Question> getQuestion(@Path("id") Long id);
}

package com.example.loginnnn

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI {
    @FormUrlEncoded
    @POST("login")
    fun loginUser (
        @Field("username") username : String,
        @Field("password") password : String) : Call<User>

}
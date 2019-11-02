package com.example.loginnnn

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User (
     @Expose
     @SerializedName("username") val username : String,

     @Expose
     @SerializedName ("password") val password : String,

     @Expose
     @SerializedName("email") val email : String,

     @Expose
     @SerializedName("fname") val fname : String,

     @Expose
     @SerializedName("lname") val lname : String,

     @Expose
     @SerializedName("age") val age : Int)

 {}
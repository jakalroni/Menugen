package com.example.menugen

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*

data class ResponseDC(var result:String? = null)

public interface ApiService {
    @POST("/users/signUp") //회원가입
    @FormUrlEncoded
    fun logUp(@Field("name") name : String, @Field("id") id : String, @Field("pw") pw : String) :  Call<Void>
}

public interface LoginService{
    @FormUrlEncoded
    @POST("/users/login")
    fun requestLogin(
        @Field("userid") userid:String,
        @Field("userpw") userpw:String
    ) : Call<Login>
}
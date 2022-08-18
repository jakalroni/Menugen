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
// 로그인
public interface LoginService{
    @FormUrlEncoded
    @POST("/users/login")
    fun requestLogin(
        @Field("userid") userid:String,
        @Field("userpw") userpw:String
    ) : Call<Login>
}
// 회원가입
public interface JoinService{
    @FormUrlEncoded
    @POST("/users/signup")
    fun requestJoin(
        @Field("userId") id:String,
        @Field("userPassword") pw:String,
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("sex") sex: Int,
        @Field("age") age: Int,
        @Field("height") height: Int,
        @Field("weight") weight: Int
        //@Field("Uallergy") Uallergy:String,
        //@Field("Udia") Udia:String
    ) : Call<Join>
}
package net.azarquiel.foroslim_api.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by alberto on 19/02/2018.
 */
interface APIForumPost {


    @FormUrlEncoded
    @POST("user")
    fun addUser(@Field("telefono") phone: String,
                @Field("nick") nick: String)


    @FormUrlEncoded
    @POST("tema")
    fun addTopic(@Field("_id") id: Int,
                 @Field("description") description: String)


    @FormUrlEncoded
    @POST("tema/{topic}/comentarios")
    fun addPost(@Path("topic") id: Int,
                @Field("telefono") phone: String,
                @Field("nick") nick: String,
                @Field("_id") _id: Int,
                @Field("fecha") date: String,
                @Field("post") post: String)

    @FormUrlEncoded
    @POST("user/{user}/avatar")
    fun addAvatar(@Path("user") user: String,
                  @Field("avatar") avatar: String)


    companion object {
        fun create(): APIForumPost {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("localhost/")
                    .build()
            return retrofit.create(APIForumPost::class.java)
        }
    }
}
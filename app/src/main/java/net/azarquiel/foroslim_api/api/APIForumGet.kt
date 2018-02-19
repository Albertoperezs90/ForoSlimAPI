package net.azarquiel.foroslim_api.api

import rx.Observable
import net.azarquiel.foroslim_api.model.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by alberto on 19/02/2018.
 */
interface APIForumGet {


    @GET("users")
    fun getUsers(): Observable<Response>

    @GET("/user/{phone}")
    fun getUser(@Path("phone") phone: String): Observable<Response>


    @GET("/temas")
    fun getTopics(): Observable<Response>


    @GET("/tema/{topic}/comentarios")
    fun getPostByTopic(@Path("topic") id: Int): Observable<Response>

    companion object {
        fun create(): APIForumGet {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl("localhost/")
                    .build()
            return retrofit.create(APIForumGet::class.java)
        }
    }
}
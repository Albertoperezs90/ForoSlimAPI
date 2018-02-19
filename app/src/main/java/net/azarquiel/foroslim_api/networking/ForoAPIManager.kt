package net.azarquiel.foroslim_api.networking

import android.util.Log
import net.azarquiel.foroslim_api.api.APIForumGet
import net.azarquiel.foroslim_api.view.MainActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by alberto on 19/02/2018.
 */
class ForoAPIManager {

    private val foroAPI by lazy {
        APIForumGet.create()
    }

    fun getUsers(){
       foroAPI.getUsers()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe( {
                   users ->
                        MainActivity.USERS.clear()
                        MainActivity.USERS.addAll(users.users.toMutableList())
                        MainActivity.ADAPTER.notifyDataSetChanged()
                    },
                       { error -> Log.e("ERROR", error.message)}
               )
    }

    fun getTopics(){
        foroAPI.getTopics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    topics ->
                        MainActivity.TOPICS.clear()
                        MainActivity.TOPICS.addAll(topics.temas.toMutableList())
                        MainActivity.ADAPTER.notifyDataSetChanged()
                },
                        { error -> Log.e("ERROR", error.message)}
                )
    }
}
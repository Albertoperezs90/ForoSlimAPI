package net.azarquiel.foroslim_api.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arlib.floatingsearchview.FloatingSearchView
import kotlinx.android.synthetic.main.activity_main.*
import net.azarquiel.foroslim_api.R
import net.azarquiel.foroslim_api.adapter.CustomAdater
import net.azarquiel.foroslim_api.model.Topic
import net.azarquiel.foroslim_api.model.User
import net.azarquiel.foroslim_api.networking.ForoAPIManager

class MainActivity : AppCompatActivity(), FloatingSearchView.OnQueryChangeListener {

    companion object {
        var USERS: MutableList<User> = mutableListOf()
        var TOPICS: MutableList<Topic> = mutableListOf()
        lateinit var ADAPTER: CustomAdater
    }

    private lateinit var foroAPI: ForoAPIManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ADAPTER = CustomAdater(this, R.layout.main_row, TOPICS)
        foroAPI.getUsers()
    }

    override fun onSearchTextChanged(oldQuery: String, newQuery: String) {
        TOPICS = TOPICS.filter { it.description.startsWith(newQuery) }.toMutableList()
        search.swapSuggestions(TOPICS)
    }


}

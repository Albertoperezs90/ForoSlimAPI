package net.azarquiel.foroslim_api.model

import android.os.Parcel
import android.os.Parcelable
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion

/**
 * Created by alberto on 19/02/2018.
 */

data class Response (val users: MutableList<User>, val temas: MutableList<Topic>, val comentarios: MutableList<Post>)

data class User (var telefono: String, var nick: String): SearchSuggestion {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBody(): String {
        return nick
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}

data class Topic (var _id: Int, var description : String): SearchSuggestion {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()) {
    }
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getBody(): String {
        return description
    }

    companion object CREATOR : Parcelable.Creator<Topic> {
        override fun createFromParcel(parcel: Parcel): Topic {
            return Topic(parcel)
        }

        override fun newArray(size: Int): Array<Topic?> {
            return arrayOfNulls(size)
        }
    }
}

data class Post (val telefono: String, val nick: String, val _id: Int, val fecha: String, var post: String)

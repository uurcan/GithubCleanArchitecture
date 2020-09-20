package com.example.githubapiexample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    @Expose
    var login : String?,
    @SerializedName("id")
    @Expose
    var id : Int = 0,
    @SerializedName("avatar_url")
    @Expose
    var avatar_url : String?,
    @SerializedName("name")
    @Expose
    var name : String?,
    @SerializedName("company")
    @Expose
    var company : String?,
    @SerializedName("location")
    @Expose
    var location : String?,
    @SerializedName("bio")
    @Expose
    var bio : String?,
    @SerializedName("public_repos")
    @Expose
    var public_repos : Int = 0,
    @SerializedName("followers")
    @Expose
    var followers : Int = 0,
    @SerializedName("following")
    @Expose
    var following : Int = 0
)
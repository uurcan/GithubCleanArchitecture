package com.example.githubapiexample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Title")
    @Expose
    var Title : String?,
    @SerializedName("Year")
    @Expose
    var Year : Int = 0,
    @SerializedName("imdbID")
    @Expose
    var imdbID : String?,
    @SerializedName("Type")
    @Expose
    var Type : String?,
    @SerializedName("Poster")
    @Expose
    var Poster : String?
)
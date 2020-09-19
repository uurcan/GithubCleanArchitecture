package com.example.githubapiexample

data class User(
    var login : String?,
    var id : Int = 0,
    var avatar_url : String?,
    var name : String?,
    var company : String?,
    var location : String?,
    var bio : String?,
    var public_repos : Int = 0,
    var followers : Int = 0,
    var following : Int = 0
)
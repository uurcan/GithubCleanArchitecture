package com.example.githubapiexample.data.github

import com.example.githubapiexample.model.SearchUserResult
import com.example.githubapiexample.model.User

public interface GithubDataSource{
    fun searchUser(query : String) : SearchUserResult

    fun getUser(username : String) : User
}
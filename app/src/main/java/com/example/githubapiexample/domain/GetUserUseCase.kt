package com.example.githubapiexample.domain

import com.example.githubapiexample.data.github.GithubDataSource
import com.example.githubapiexample.model.User
import com.example.githubapiexample.utils.executor.ExecutorProvider

class GetUserUseCase(executorProvider: ExecutorProvider,
    private val githubDataSource: GithubDataSource) : UseCase<String,User>(executorProvider){
    override fun execute(params: String): User {
        return githubDataSource.getUser(username = params)
    }
}
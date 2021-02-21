package com.example.githubapiexample.domain

import com.example.githubapiexample.data.github.GithubDataSource
import com.example.githubapiexample.model.SearchUserResult
import com.example.githubapiexample.utils.executor.ExecutorProvider
import com.example.githubapiexample.utils.logging.LoggingHelper

class SearchUseCase(
    executorProvider: ExecutorProvider,
    private val githubDataSource: GithubDataSource,
    private val loggingHelper: LoggingHelper
) : UseCase<String,SearchUserResult>(executorProvider){
    companion object {
        private const val TAG = "SearchUseCase"
    }

    override fun execute(params: String): SearchUserResult {
        try {
            loggingHelper.debug(TAG,"Query added to the search history")
        } catch (error : Throwable) {
            loggingHelper.warn(TAG,"An error occurred while adding a query to the search history",error)
        }

        return githubDataSource.searchUser(query = params)
    }
}
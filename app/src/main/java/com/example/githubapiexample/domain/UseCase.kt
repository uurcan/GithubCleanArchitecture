package com.example.githubapiexample.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubapiexample.utils.executor.ExecutorProvider

abstract class UseCase<in P,R> constructor(private val executorProvider : ExecutorProvider){
    fun executeAsync(params: P): LiveData<Result<R>> {
        val result = MutableLiveData<Result<R>>()
        result.value = Result.Loading
        executorProvider.io().submit{
            try {
                result.postValue(Result.Success(execute(params)))
            } catch (error : Throwable) {
                result.postValue(Result.Error(error))
            }
        }
        return result
    }
    abstract fun execute(params: P):R
    sealed class Result<out T> {
        class Success<out T>(val data:T):Result<T>()
        class Error<out T>(val data:T):Result<Nothing>()
        object Loading : Result<Nothing>()
    }
}
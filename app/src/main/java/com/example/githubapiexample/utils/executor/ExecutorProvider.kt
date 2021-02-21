package com.example.githubapiexample.utils.executor

import java.util.concurrent.ExecutorService

interface ExecutorProvider {
    fun computation(): ExecutorService
    fun io(): ExecutorService
    fun ui(): ExecutorService
}
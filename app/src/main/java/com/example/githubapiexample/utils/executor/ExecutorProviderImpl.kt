package com.example.githubapiexample.utils.executor

import android.os.Handler
import android.os.Looper
import java.lang.UnsupportedOperationException
import java.util.concurrent.AbstractExecutorService
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object ExecutorProviderImpl : ExecutorProvider {
    private val computationExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    private val ioExecutor  = Executors.newCachedThreadPool()
    private val uiExecutor = object : AbstractExecutorService() {
        private val handler : Handler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            if(handler.looper == Looper.myLooper()){
                command.run()
            } else {
                handler.post(command)
            }
        }
        override fun isTerminated(): Boolean {
            return false
        }

        override fun shutdown() {
            throw UnsupportedOperationException()
        }

        override fun shutdownNow(): MutableList<Runnable> {
            throw UnsupportedOperationException()
        }

        override fun isShutdown(): Boolean {
            return false
        }

        override fun awaitTermination(timeout: Long, unit: TimeUnit): Boolean {
            throw UnsupportedOperationException()
        }

    }

    override fun computation(): ExecutorService {
        return computationExecutor
    }

    override fun io(): ExecutorService {
        return ioExecutor
    }

    override fun ui(): ExecutorService {
        return uiExecutor
    }
}
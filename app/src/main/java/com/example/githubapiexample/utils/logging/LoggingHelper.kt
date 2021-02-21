package com.example.githubapiexample.utils.logging

interface LoggingHelper {

    fun debug(tag: String, message: String)

    fun debug(tag: String, message: String, t: Throwable)

    fun info(tag: String, message: String)

    fun info(tag: String, message: String, t: Throwable)

    fun warn(tag: String, message: String)

    fun warn(tag: String, message: String, t: Throwable)

    fun error(tag: String, message: String)

    fun error(tag: String, message: String, t: Throwable)
}

package com.example.githubapiexample.utils.logging

import android.util.Log


object LoggingHelperImpl : LoggingHelper {

    override fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun debug(tag: String, message: String, t: Throwable) {
        Log.d(tag, message, t)
    }

    override fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun info(tag: String, message: String, t: Throwable) {
        Log.i(tag, message, t)
    }

    override fun warn(tag: String, message: String) {
        Log.w(tag, message)
    }

    override fun warn(tag: String, message: String, t: Throwable) {
        Log.w(tag, message, t)
    }

    override fun error(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun error(tag: String, message: String, t: Throwable) {
        Log.e(tag, message, t)
    }
}

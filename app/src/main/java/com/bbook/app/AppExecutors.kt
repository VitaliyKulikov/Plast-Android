package com.bbook.app

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors(ioThreadsCount: Int) {

    val ioExecutor = Executors.newFixedThreadPool(ioThreadsCount)!!
    val mainThreadExecutor = MainExecutor()

    inner class MainExecutor : Executor {

        private val mainHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable?) {
            mainHandler.post(command)
        }
    }
}
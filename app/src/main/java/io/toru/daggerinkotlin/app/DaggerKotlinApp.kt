package io.toru.daggerinkotlin.app

import android.app.Application

/**
 * Created by wonyoung on 2017. 1. 4..
 */
class DaggerKotlinApp : Application() {

    companion object{
        lateinit var app:DaggerKotlinApp

        fun test():Int{
            return 1;
        }
    }
    override fun onCreate() {
        super.onCreate()
        app = this
    }
}
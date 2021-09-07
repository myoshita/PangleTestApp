package com.example.pangletestapp

import android.app.Application
import android.util.Log
import com.bytedance.sdk.openadsdk.TTAdConfig
import com.bytedance.sdk.openadsdk.TTAdSdk

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

        val config = TTAdConfig.Builder()
            .appId(BuildConfig.APP_ID)
            .build()

        TTAdSdk.init(this, config, object : TTAdSdk.InitCallback {
            override fun success() {
                Log.d(TAG, "success")
            }

            override fun fail(code: Int, message: String?) {
                Log.w(TAG, "fail code: $code message: $message")
            }
        })
    }

    companion object {
        const val TAG = "App"
    }
}
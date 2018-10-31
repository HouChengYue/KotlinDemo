package com.xnyc.yuncai.moudle.net

import com.xnyc.yuncai.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Creat by HCY on2018/10/31
 * 描述：单例类ApiClient
 */
class ApiClient private constructor() {
    lateinit var service: Ipserver

    private object Holder {
        var INSTANCE = ApiClient()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun init() {
        val okhttClient = OkHttpClient().newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    )
            ).build()
        var retrofit =Retrofit.Builder()
            .baseUrl(Urls().BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okhttClient)
            .build()

        service=retrofit.create(Ipserver::class.java)

    }


}
package com.xnyc.yuncai

import android.app.Application
import com.xnyc.yuncai.moudle.net.ApiClient

/**
 * Creat by HCY on2018/10/31
 * 描述：App 的Application 类
 */
class App:Application() {
    override fun onCreate() {
        super.onCreate()
//        初始化网络请求框架
        ApiClient.instance.init()
    }
}
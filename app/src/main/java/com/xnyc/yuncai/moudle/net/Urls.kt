package com.xnyc.yuncai.moudle.net

import com.xnyc.yuncai.BuildConfig

/**
 * Creat by HCY on2018/10/31
 * 描述：Urls
 */
class Urls {
//    val BASE_URL="https://api.github.com/"// 用的github api 为例

    var BASE_URL: String = ""

    constructor() {
        when (BuildConfig.BUILD_TYPE) {
            "debug" -> BASE_URL = "https://api.github.com/"
        }
    }



}

package com.xnyc.yuncai.moudle.net

/**
 * Creat by HCY on2018/10/31
 * 描述：
 */
data class ResponseWrapper<T>(var code: Int, var data: T, var message: String) {

}
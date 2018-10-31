package com.xnyc.yuncai.moudle.net

import android.content.Context
import androidx.annotation.StringRes
import com.xnyc.yuncai.R

/**
 * Creat by HCY on2018/10/31
 * 描述：  错误码含义
 */
enum class ApiErroType(var code: Int, @param:StringRes private val messageId: Int) {
    INTERNAL_SERVER_ERROR(500, R.string.service_error),
    BAD_GATEWAY(502, R.string.service_error),
    NOT_FOUND(404, R.string.not_found),
    CONNECTION_TIMEOUT(408, R.string.timeout),
    NETWORK_NOT_CONNECT(499, R.string.network_wrong),
    UNEXPECTED_ERROR(700, R.string.unexpected_error);

    private val DEFAULT_CODE = 1

    fun getApiErrorModel(context: Context): ApiErroModle {
        return ApiErroModle(DEFAULT_CODE, context.getString(messageId))
    }
}
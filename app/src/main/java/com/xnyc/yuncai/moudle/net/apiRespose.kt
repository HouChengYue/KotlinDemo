package com.xnyc.yuncai.moudle.net

import android.app.Dialog
import android.content.Context
import com.google.gson.Gson
import com.xnyc.yuncai.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException

/**
 * Creat by HCY on2018/10/31
 * 描述： 响应体
 */
abstract class ApiResponse<T>(private val context: Context) : Observer<T> {
    /**
     * 成功返回
     */
    abstract fun success(data: T)

    /**
     *  失败返回  statusCodes:状态码
     */
    abstract fun failure(statusCodes: Int, apiErrroModel: ApiErroModle)

    override fun onSubscribe(d: Disposable) {
        LoadingDialog.show(context)
    }

    override fun onNext(t: T) {
        success(t)
    }

    override fun onComplete() {
        LoadingDialog.cancle()
    }


    override fun onError(e: Throwable) {
        LoadingDialog.cancle()
        if (e is HttpException) {
            val apiErroModle: ApiErroModle =
                when (e.code()) {
                    ApiErroType.INTERNAL_SERVER_ERROR.code ->
                        ApiErroType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
                    ApiErroType.BAD_GATEWAY.code ->
                        ApiErroType.BAD_GATEWAY.getApiErrorModel(context)
                    ApiErroType.NOT_FOUND.code ->
                        ApiErroType.NOT_FOUND.getApiErrorModel(context)
                    else -> otherError(e)

                }
            failure(e.code(), apiErroModle)
            return
        }

        val apiErroType: ApiErroType = when (e) {
            is UnknownHostException -> ApiErroType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErroType.NETWORK_NOT_CONNECT
            is SocketException -> ApiErroType.CONNECTION_TIMEOUT
            else -> ApiErroType.UNEXPECTED_ERROR
        }
        failure(apiErroType.code, apiErroType.getApiErrorModel(context))
    }


    private fun otherError(e: HttpException) = Gson().fromJson(
        e.response().errorBody()?.charStream(),
        ApiErroModle::class.java
    )


}

object LoadingDialog {
    private var dialog: Dialog? = null
    fun show(context: Context) {
        cancle()
        dialog = Dialog(context, R.style.LoadingDailog)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancle() {
        dialog?.dismiss()
    }

}
package com.xnyc.yuncai.moudle.net

import com.xnyc.yuncai.moudle.bean.Repo
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

/**
 * Creat by HCY on2018/10/31
 * 描述： 网络访问接口
 */
interface Ipserver {
    //Get
    @GET("user/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>>


    @Multipart
    @POST("xxxx/xxxx") //This is imaginary URL
    fun updateImage(@Part("name") name: RequestBody,
                    @Part image: MultipartBody.Part): Observable<String>

    @GET("xxx/xxx") //用于使用ResponseWrapper的举例，实际使用此API将无效
    fun repos(@Path("user") user: String): Observable<ResponseWrapper<List<Repo>>> //使用ResponseWrapper时注意Observable尖括号里的内容


}
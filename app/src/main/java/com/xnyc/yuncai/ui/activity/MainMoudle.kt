package com.xnyc.yuncai.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Creat by HCY on2018/11/2
 * 描述：
 */
class MainMoudle : ViewModel() {
    val data :MutableLiveData<Int> = MutableLiveData<Int>()
    fun setData(postion: Int){
        data.postValue(postion)
    }



}
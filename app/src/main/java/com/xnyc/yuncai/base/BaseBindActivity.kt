package com.xnyc.yuncai.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Creat by HCY on2018/10/30
 * 描述：
 */

open class BaseBindActivity<T : ViewDataBinding> : RxAppCompatActivity() {
    lateinit var mBinding: T

    override fun setContentView(layoutResID: Int) {
        mBinding=DataBindingUtil.inflate(layoutInflater,layoutResID,null,false)
        super.setContentView(mBinding.root)
    }



}
package com.xnyc.yuncai.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity

/**
 * Creat by HCY on2018/10/30
 * 描述：
 */

public class BaseBindActivity<T : ViewDataBinding> : AppCompatActivity() {
    lateinit var mBinding: ViewDataBinding

    override fun setContentView(layoutResID: Int) {
        mBinding=DataBindingUtil.inflate<T>(layoutInflater,layoutResID,null,false)
        super.setContentView(mBinding.root)
    }



}
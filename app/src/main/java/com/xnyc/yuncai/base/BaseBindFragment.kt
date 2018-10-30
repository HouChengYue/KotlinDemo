package com.xnyc.yuncai.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Creat by HCY on2018/10/30
 * 描述：
 */
public abstract class BaseBindFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var mBinding: ViewDataBinding
    private var init: Boolean = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, setLayout(), container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init = true
        initView()
        loadData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (init && isVisibleToUser) {
            loadData()
        }
    }

    abstract fun setLayout(): Int

    abstract fun initView()

    abstract fun loadData()

}
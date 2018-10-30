package com.xnyc.yuncai.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xnyc.yuncai.R
import com.xnyc.yuncai.base.BaseBindFragment
import com.xnyc.yuncai.databinding.TestFragmentBinding
import com.xnyc.yuncai.ui.viewModule.TestViewModel


class TestFragment : BaseBindFragment<TestFragmentBinding>() {
    lateinit var tiltle: String;
    private lateinit var viewModel: TestViewModel
    protected lateinit var mBinding: TestFragmentBinding


    companion object {
        fun newInstance() = TestFragment()
        fun newInstance(tiltle: String): TestFragment {
            var testFragment = TestFragment()
            testFragment.tiltle = tiltle
            return testFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, setLayout(), container, false)
        return mBinding.root
    }


    override fun setLayout(): Int {
        return R.layout.test_fragment
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        viewModel.tilte = tiltle
        mBinding.bean = viewModel
    }

    override fun loadData() {

    }
}

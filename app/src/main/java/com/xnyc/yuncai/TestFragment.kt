package com.xnyc.yuncai

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xnyc.yuncai.databinding.TestFragmentBinding


class TestFragment : Fragment() {
    lateinit var tiltle: String;
    private lateinit var viewModel: TestViewModel
    private lateinit var mBinding: TestFragmentBinding


    companion object {
        fun newInstance() = TestFragment()
        fun newInstance(tiltle: String): TestFragment {
            var testFragment = TestFragment()
            testFragment.tiltle = tiltle
            return testFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.test_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        viewModel.tilte = tiltle
        mBinding.bean=viewModel

    }

}

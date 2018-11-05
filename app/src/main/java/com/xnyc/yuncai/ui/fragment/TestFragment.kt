package com.xnyc.yuncai.ui.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xnyc.yuncai.R
import com.xnyc.yuncai.base.BaseBindFragment
import com.xnyc.yuncai.databinding.TestFragmentBinding
import com.xnyc.yuncai.ui.activity.MainMoudle
import com.xnyc.yuncai.ui.viewModule.TestViewModel
import kotlinx.android.synthetic.main.test_fragment.*


class TestFragment : BaseBindFragment<TestFragmentBinding>() {
     var tiltle: String="默认title";
    private lateinit var viewModel: TestViewModel
    private lateinit var mainMoudle: MainMoudle;


    companion object {
        fun newInstance() = TestFragment()
        fun newInstance(tiltle: String): TestFragment {
            var testFragment = TestFragment()
            testFragment.tiltle = tiltle
            return testFragment
        }
    }


    override fun setLayout(): Int {
        return R.layout.test_fragment
    }

    override fun initView() {
        mainMoudle = ViewModelProviders.of(this).get(MainMoudle::class.java)

        viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        viewModel.tilte = tiltle
        mBinding.bean = viewModel


        activity?.let {
            mainMoudle.data.observe(it, Observer {
                mBinding.tvOne.text=it.toString()
            })
        }

        btnToFour.setOnClickListener {
            mainMoudle.setData(3)
        }

        btnToThree.setOnClickListener {
            mainMoudle.setData(2)
        }




    }

    override fun loadData() {

    }
}

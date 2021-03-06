package com.xnyc.yuncai.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.xnyc.yuncai.R
import com.xnyc.yuncai.adapter.ViewPagerAdapter
import com.xnyc.yuncai.base.BaseBindActivity
import com.xnyc.yuncai.databinding.ActivityMainBinding
import com.xnyc.yuncai.ui.fragment.DataFragment
import com.xnyc.yuncai.ui.fragment.TestFragment

class MainActivity : BaseBindActivity<ActivityMainBinding>() {
    lateinit var menuItem: MenuItem

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager, listOf(
//                TestFragment.newInstance("主页"),
                DataFragment.newInstance(),
                TestFragment.newInstance("分类"),
                TestFragment.newInstance("订单"),
                TestFragment.newInstance("我的")
            )
        )



        mBinding.vpMain.adapter = viewPagerAdapter
        mBinding.vpMain.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                menuItem = mBinding.bnvMain.menu.getItem(p0).setChecked(true)
            }

        })

        mBinding.bnvMain.setOnNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener,
            BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                menuItem = p0
                when (p0.itemId) {
                    R.id.tab_one -> mBinding.vpMain.currentItem = 0
                    R.id.tab_two -> mBinding.vpMain.currentItem = 1
                    R.id.tab_three -> mBinding.vpMain.currentItem = 2
                    R.id.tab_four -> mBinding.vpMain.currentItem = 3
                }
                return false
            }
        })

        var get = ViewModelProviders.of(this).get(MainMoudle::class.java)
        get.data.observe(this, Observer {

            Log.e("Main","Cruuent item is $it")
            mBinding.vpMain.currentItem=it
        })

    }

}

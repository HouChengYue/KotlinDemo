package com.xnyc.yuncai.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Creat by HCY on2018/10/29
 * 描述：
 */

public class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager, private var fragments: List<androidx.fragment.app.Fragment>) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return fragments.size
    }


}
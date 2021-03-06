package com.andy.kotlin.gank.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.andy.kotlin.gank.R
import com.andy.kotlin.gank.fragment.GankDayFragment
import com.andy.kotlin.gank.fragment.GankRandomFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private var mPagerAdapter: FragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        mPagerAdapter = MainFragmentPagerAdapter(supportFragmentManager)
        mViewPager.adapter = mPagerAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private class MainFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        val pageTitleList = arrayOf("精品", "随机")
        val fragmentList = arrayOfNulls<Fragment>(pageTitleList.size)

        override fun getItem(position: Int): Fragment {
            var fragment = fragmentList[position]
            if (fragment == null) {
                fragment = when (position) {
                    0 -> GankDayFragment()
                    1 -> GankRandomFragment()
                    else -> null
                }
                fragmentList[position] = fragment
            }
            return fragment!!
        }

        override fun getCount(): Int = fragmentList.size

        override fun getPageTitle(position: Int): CharSequence = pageTitleList[position]
    }
}
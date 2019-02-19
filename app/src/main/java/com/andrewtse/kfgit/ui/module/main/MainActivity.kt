package com.andrewtse.kfgit.ui.module.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andrewtse.kfgit.R
import com.andrewtse.kfgit.ui.module.main.fragment.FragmentsDataGenerator
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    lateinit var mFragments: Array<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFragments = FragmentsDataGenerator.getFragments()
        initView()
    }

    private fun initView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener { menuItem ->
            onTabItemSelected(menuItem.itemId)
            true
        }

        onTabItemSelected(R.id.tab_menu_trending)
    }

    private fun onTabItemSelected(position: Int) {
        lateinit var fragment: Fragment
        when (position) {
            R.id.tab_menu_trending -> fragment = mFragments[0]
            R.id.tab_menu_search -> fragment = mFragments[1]
            R.id.tab_menu_stars -> fragment = mFragments[2]
            R.id.tab_menu_profile -> fragment = mFragments[3]
        }
        supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit()
    }
}

package com.andrewtse.kfgit.ui.module.main.fragment

import androidx.fragment.app.Fragment

/**
 * @author xk
 * @date 2019/2/19
 */
open class FragmentsDataGenerator {

    companion object {
        fun getFragments(): Array<Fragment> {
            return arrayOf(TrendingFragment.newInstance(), SearchFragment.newInstance(), StarFragment.newInstance(), ProfileFragment.newInstance())
        }
    }
}
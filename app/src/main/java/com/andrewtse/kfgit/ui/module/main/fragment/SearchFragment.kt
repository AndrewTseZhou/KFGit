package com.andrewtse.kfgit.ui.module.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.andrewtse.kfgit.R
import com.andrewtse.kfgit.ui.base.BaseFragment

/**
 * @author xk
 * @date 2019/2/19
 */
open class SearchFragment : BaseFragment() {

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, null)
        val content = view.findViewById(R.id.fragment_content) as TextView
        content.text = "SearchFragment"

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
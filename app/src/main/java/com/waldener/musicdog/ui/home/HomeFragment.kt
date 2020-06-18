package com.waldener.musicdog.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waldener.musicdog.R
import com.waldener.musicdog.ui.attention.AttentionFragment
import com.waldener.musicdog.ui.recent.RecentFragment
import com.waldener.musicdog.ui.recommend.RecommendFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val fragments: List<Fragment> = arrayListOf(
        RecommendFragment(),
        RecentFragment(),
        AttentionFragment()
    )

    private val titles = arrayListOf(
        "今日推荐",
        "最近播放",
        "我的关注"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = HomePagerAdapter(childFragmentManager, fragments, titles)
        view_pager.offscreenPageLimit = 1
        tab_layout.setupWithViewPager(view_pager)
    }
}
package com.waldener.musicdog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.waldener.musicdog.data.Search
import com.waldener.musicdog.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
//            Thread{
//                Search.search("成龙")
//            }.start()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
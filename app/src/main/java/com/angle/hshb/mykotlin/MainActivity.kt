package com.angle.hshb.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.angle.hshb.mykotlin.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items= listOf(
            "Mon 8/20 - Sunny - 31/17",
            "Tue 8/21 - Foggy - 31/17",
            "Wed 8/22 - Cloudy - 31/17",
            "Thurs 8/23 - Rainy - 31/17",
            "Fri 8/24 - Foggy - 31/17",
            "Sat 8/25 - TRAPPEN IN WEATHERSTATION - 31/17",
            "Sun 8/26 - Sunny - 31/17"
    )
    var s="KotlitHshb"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        tvText.text = "欢迎来到Kotlin"
        toast("这是一个吐丝")
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=ForecastListAdapter(items)
        for (c in s){
            println("$c==KotlitHshb")
        }
    }

    /**
     * 第二个参数是一个默认的参数，不传默认Short
     */
    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }
}

package me.gilo.woodroid.app.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import me.gilo.woodroid.app.R

import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_menu.*
import me.gilo.woodroid.app.adapter.MenuAdapter
import java.util.ArrayList

class MenuActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

        title = "Menu"

        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        rvMenu.layoutManager = layoutManager
        rvMenu.isNestedScrollingEnabled = false

        var titles = ArrayList<String>()
        titles.add("Products")
        titles.add("Coupons")

        var adapter = MenuAdapter(titles)
        rvMenu.adapter = adapter

    }

}

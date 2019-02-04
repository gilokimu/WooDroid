package me.gilo.wc.ui

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_menu.*
import me.gilo.wc.adapter.MenuAdapter
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

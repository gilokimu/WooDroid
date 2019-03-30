package me.gilo.wc.ui.order

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_my_orders.*

class MyOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)
        setSupportActionBar(toolbar)

    }

}

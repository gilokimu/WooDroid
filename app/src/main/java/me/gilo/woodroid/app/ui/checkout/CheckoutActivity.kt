package me.gilo.woodroid.app.ui.checkout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.gilo.woodroid.app.R

import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        setSupportActionBar(toolbar)

    }

}

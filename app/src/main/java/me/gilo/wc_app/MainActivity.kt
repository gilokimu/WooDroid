package me.gilo.wc_app

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.Woocommerce.Builder
import me.gilo.woodroid.callback.Status

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val woocommerce = Builder()
            .setSiteUrl("")
            .setApiVersion("")
            .setConsumerKey("")
            .setConsumerSecret("")
            .build()

        woocommerce.products.
    }
}

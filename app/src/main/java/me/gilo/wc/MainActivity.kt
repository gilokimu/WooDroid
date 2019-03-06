package me.gilo.wc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.gilo.wc.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(baseContext, HomeActivity::class.java))
        finish()

    }
}

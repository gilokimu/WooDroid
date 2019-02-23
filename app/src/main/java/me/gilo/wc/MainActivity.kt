package me.gilo.wc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.gilo.wc.ui.MenuActivity
import me.gilo.wc.ui.product.ShopActivity
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Coupon
import me.gilo.woodroid.models.Product
import java.util.ArrayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(baseContext, ShopActivity::class.java));
        finish()

    }
}

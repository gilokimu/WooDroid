package me.gilo.wc_app

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.Woocommerce.Builder
import me.gilo.woodroid.callback.Status
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

        val woocommerce = Woocommerce.Builder()
            .setSiteUrl("http://157.230.131.179")
            .setApiVersion("2")
            .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
            .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
            .build()


        woocommerce.products.enqueue(object : Callback<ArrayList<Product>> {
            override fun onResponse(call: Call<ArrayList<Product>>, response: Response<ArrayList<Product>>) {
                val products = response.body()
                for (product in products!!) {
                    tvText.append(product.title)
                }
            }

            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {

            }
        })
    }
}

package me.gilo.wc.ui.coupon

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_coupon.*
import kotlinx.android.synthetic.main.content_add_coupon.*
import me.gilo.wc.R
import me.gilo.wc.ui.BaseActivity
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Coupon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCouponActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_coupon)
        setSupportActionBar(toolbar)

        bCreate.setOnClickListener { submit() }

    }

    private fun submit() {
        val code = etCode.text.toString()
        val description = etDescription.text.toString()
        
        val coupon = Coupon()
        coupon.code = code
        coupon.description = description
        
        createCoupon(coupon)
    }

    private fun createCoupon(coupon: Coupon) {
        showLoading("Loading", "This won't take long")

        val woocommerce = Woocommerce.Builder()
            .setSiteUrl("http://157.230.131.179")
            .setApiVersion(Woocommerce.API_V2)
            .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
            .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
            .build()

        woocommerce.Coupon().create(coupon).enqueue(object : Callback<Coupon> {
            override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
                val couponResponse = response.body()
                stopShowingLoading()
                finish()
            }

            override fun onFailure(call: Call<Coupon>, t: Throwable) {
                stopShowingLoading()
            }
        })
    }

}

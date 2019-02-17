package me.gilo.wc.ui.coupon

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_coupon.*
import kotlinx.android.synthetic.main.content_coupon.*
import me.gilo.wc.R
import me.gilo.wc.adapter.CouponAdapter
import me.gilo.wc.ui.BaseActivity
import me.gilo.woodroid.Woocommerce
import me.gilo.woodroid.models.Coupon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CouponActivity : BaseActivity() {


    lateinit var adapter : CouponAdapter
    lateinit var coupons: ArrayList<Coupon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)
        setSupportActionBar(toolbar)

        title = "Coupon"

        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        rvCoupons.layoutManager = layoutManager
        rvCoupons.isNestedScrollingEnabled = false

        coupons = ArrayList()

        adapter = CouponAdapter(coupons)
        rvCoupons.adapter = adapter

        coupons()

        fab.setOnClickListener{
            startActivity(Intent(baseContext, AddCouponActivity::class.java))
        }

    }

    //Not best practise, but works for purposes of demo
    private fun coupons() {
        val woocommerce = Woocommerce.Builder()
            .setSiteUrl("http://157.230.131.179")
            .setApiVersion(Woocommerce.API_V2)
            .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
            .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
            .build()

        woocommerce.Coupon().coupons().enqueue(object : Callback<List<Coupon>> {
            override fun onResponse(call: Call<List<Coupon>>, response: Response<List<Coupon>>) {
                val couponResponse = response.body()
                for (coupon in couponResponse!!) {
                    coupons.add(coupon)
                }

                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Coupon>>, t: Throwable) {

            }
        })
    }

}

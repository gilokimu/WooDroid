package me.gilo.woodroid.app.ui.coupon

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_coupon.*
import kotlinx.android.synthetic.main.content_coupon.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.ui.BaseActivity
import me.gilo.woodroid.models.Coupon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class CouponActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)
        setSupportActionBar(toolbar)

        title = "Coupon"

        val couponId = intent.getIntExtra("couponId", 0)

        if (couponId != 0){
            getCoupon(couponId)

            bDelete.setOnClickListener{delete(couponId)}
            bUpdate.setOnClickListener{
                val coupon = Coupon()
                coupon.id = couponId
                coupon.code = etCode.text.toString()
                coupon.description = etDescription.text.toString()

                update(coupon)
            }

        }else{
            Toast.makeText(baseContext, "You did not pass coupon id", Toast.LENGTH_LONG).show()
        }

    }

    private fun getCoupon(couponId: Int) {
        showLoading()

        woocommerce.CouponRepository().coupon(couponId).enqueue(object : Callback<Coupon> {
            override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
                val coupon = response.body()!!

                etCode.setText(coupon.code?.toUpperCase())
                etDescription.setText(coupon.description)

                stopShowingLoading()
            }

            override fun onFailure(call: Call<Coupon>, t: Throwable) {
                stopShowingLoading()
            }
        })
    }

    private fun delete(couponId: Int) {
        showLoading()

        woocommerce.CouponRepository().delete(couponId).enqueue(object : Callback<Coupon> {
            override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
                if (response.isSuccessful) {
                    val coupon = response.body()!!

                    etCode.setText(coupon.code?.toUpperCase())
                    etDescription.setText(coupon.description)

                    finish()
                }else{
                    Toast.makeText(this@CouponActivity, "" + response.code() + " : " + response.message(), Toast.LENGTH_SHORT).show()
                }

                stopShowingLoading()
            }

            override fun onFailure(call: Call<Coupon>, t: Throwable) {
                stopShowingLoading()
            }
        })
    }


    private fun update(coupon: Coupon) {
        showLoading()

        woocommerce.CouponRepository().update(coupon.id, coupon).enqueue(object : Callback<Coupon> {
            override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
                val coupon = response.body()!!

                etCode.setText(coupon.code?.toUpperCase())
                etDescription.setText(coupon.description)

                stopShowingLoading()

                finish()
            }

            override fun onFailure(call: Call<Coupon>, t: Throwable) {
                stopShowingLoading()
            }
        })
    }

}

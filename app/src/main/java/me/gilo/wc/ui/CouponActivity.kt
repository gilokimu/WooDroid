package me.gilo.wc.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import me.gilo.wc.R

import kotlinx.android.synthetic.main.activity_coupon.*

class CouponActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)
        setSupportActionBar(toolbar)

        title = "Coupon"

    }

}

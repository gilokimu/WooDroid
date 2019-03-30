package me.gilo.wc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.product.ProductActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(baseContext, SignInActivity::class.java))

//        val intent = Intent(baseContext, ProductActivity::class.java)
//        intent.putExtra("productId", 63)
//
//        startActivity(intent)

        finish()

    }
}

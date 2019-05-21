package me.gilo.wc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.wc.ui.customer.BasicCustomerDetailsActivity
import me.gilo.wc.ui.customer.BillingAddressActivity
import me.gilo.wc.ui.customer.ShippingAddressActivity
import me.gilo.wc.ui.home.HomeActivity
import me.gilo.wc.ui.onboarding.AnonymousSignInActivity
import me.gilo.wc.ui.order.MyOrdersActivity
import me.gilo.wc.ui.product.ProductActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(baseContext, MyOrdersActivity::class.java))
        }else{
            startActivity(Intent(baseContext, AnonymousSignInActivity::class.java))
        }

        finish()

    }
}

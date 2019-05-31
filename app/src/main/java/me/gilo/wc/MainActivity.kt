package me.gilo.wc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import me.gilo.wc.ui.onboarding.AnonymousSignInActivity
import me.gilo.wc.ui.order.MyOrdersActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(baseContext, MyOrdersActivity::class.java))
        } else {
            startActivity(Intent(baseContext, AnonymousSignInActivity::class.java))
        }
        finish()

    }
}

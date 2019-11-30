package me.gilo.woodroid.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.ui.home.HomeActivity
import me.gilo.woodroid.app.ui.onboarding.AnonymousSignInActivity
import me.gilo.woodroid.app.ui.order.MyOrdersActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(baseContext, HomeActivity::class.java))
        } else {
            startActivity(Intent(baseContext, AnonymousSignInActivity::class.java))
        }
        finish()

    }
}

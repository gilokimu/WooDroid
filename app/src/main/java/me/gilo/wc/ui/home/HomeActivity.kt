package me.gilo.wc.ui.home

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_home.*
import me.gilo.wc.R
import me.gilo.wc.common.BaseActivity

class HomeActivity : BaseActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        var selectedFragment: Fragment? = HomeFragment.newInstance()

        when (item.itemId) {
            R.id.navigation_home -> {
                selectedFragment = HomeFragment.newInstance()

            }
            R.id.navigation_deals -> {
                selectedFragment = CategoryFragment.newInstance()
            }
            R.id.navigation_account -> {
                selectedFragment = ProfileFragment.newInstance()
            }
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, selectedFragment!!)
        transaction.commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()

    }
}

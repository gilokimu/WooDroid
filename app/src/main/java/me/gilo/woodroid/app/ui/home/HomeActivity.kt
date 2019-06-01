package me.gilo.woodroid.app.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import me.gilo.woodroid.app.R
import me.gilo.woodroid.app.ui.WooDroidActivity
import me.gilo.woodroid.app.viewmodels.CartViewModel

class HomeActivity : WooDroidActivity<CartViewModel>() {
    override lateinit var viewModel: CartViewModel

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

        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()

    }
}

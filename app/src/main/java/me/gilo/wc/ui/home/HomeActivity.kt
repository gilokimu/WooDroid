package me.gilo.wc.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import me.gilo.wc.R
import me.gilo.wc.common.Status
import me.gilo.wc.models.CartLineItem
import me.gilo.wc.ui.WooDroidActivity
import me.gilo.wc.viewmodels.CartViewModel
import me.gilo.wc.viewmodels.ProductViewModel
import me.gilo.woodroid.models.CartItem

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

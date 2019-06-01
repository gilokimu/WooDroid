package me.gilo.wc.ui

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.raison.ui.user.onboarding.SignInActivity
import me.gilo.wc.R
import me.gilo.wc.common.BaseActivity
import me.gilo.wc.common.Status
import me.gilo.wc.ui.product.CartActivity
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.wc.viewmodels.CartViewModel
import me.gilo.wc.viewmodels.ProductViewModel

abstract class WooDroidActivity<T : ViewModel> : BaseActivity() {


    abstract var viewModel : T
    private lateinit var progressDialog: ProgressDialogFragment

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))

    }

    override fun onResume() {
        super.onResume()

        if(FirebaseAuth.getInstance().currentUser == null){
            startActivity(Intent(baseContext, SignInActivity::class.java))
            finish()
        }
        cart()
    }

    fun showLoading() {
        showLoading("Please wait", "This will only take a second")
    }

    fun showLoading(title: String, message: String) {
        val manager = supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun stopShowingLoading() {
        progressDialog.dismiss()
    }

    fun toast(text : String){
        Toast.makeText(baseContext, text, Toast.LENGTH_LONG).show()
    }

    var tvCartCounter : TextView? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.product, menu)

        val item = menu.findItem(me.gilo.wc.R.id.menu_cart)
        val rootView = item.actionView as FrameLayout
        tvCartCounter = rootView.findViewById<TextView>(R.id.tvCart_counter)

        rootView.setOnClickListener{startActivity(Intent(baseContext, CartActivity::class.java))}

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_cart -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    open fun cart() {
        var viewModel = getViewModel(CartViewModel::class.java)

        viewModel.cart().observe(this, android.arch.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    for (cartItem in response.data()){

                    }

                    if ( response.data().size == 0 && tvCartCounter != null){
                        tvCartCounter?.visibility = View.GONE
                    }else{
                        tvCartCounter?.visibility = View.VISIBLE
                        tvCartCounter?.text =  response.data().size.toString()
                    }


                }

                Status.ERROR -> {

                }

                Status.EMPTY -> {
                    if ( response.data().size == 0 && tvCartCounter != null){
                        tvCartCounter?.visibility = View.GONE
                    }else{
                        tvCartCounter?.visibility = View.VISIBLE
                        tvCartCounter?.text =  response.data().size.toString()
                    }
                }
            }

        })

    }

}

package me.gilo.wc.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.Config
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.woodroid.Woocommerce

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog : ProgressDialogFragment

    val woocommerce = Woocommerce.Builder()
        .setSiteUrl(Config.siteUrl)
        .setApiVersion(Woocommerce.API_V3)
        .setConsumerKey(Config.consumerKey)
        .setConsumerSecret(Config.consumerSecret)
        .build()


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    fun showLoading(title: String, message: String) {
        val manager = supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun showLoading() {
       showLoading("This will only take a sec", "Loading")
    }

    fun stopShowingLoading() {
        progressDialog.dismiss()
    }
}

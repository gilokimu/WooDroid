package me.gilo.wc.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.ui.state.ProgressDialogFragment
import me.gilo.woodroid.Woocommerce

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog : ProgressDialogFragment

    val woocommerce = Woocommerce.Builder()
        .setSiteUrl("http://157.230.131.179")
        .setApiVersion(Woocommerce.API_V2)
        .setConsumerKey("ck_26c61abd7eeff238d87dc56585bf26cb2d1a1ec3")
        .setConsumerSecret("cs_062e8e3a7ae0ce08fdebc0c39f8f834d5e87598e")
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

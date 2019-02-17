package me.gilo.wc.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import me.gilo.wc.ui.state.ProgressDialogFragment

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog : ProgressDialogFragment

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
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
}

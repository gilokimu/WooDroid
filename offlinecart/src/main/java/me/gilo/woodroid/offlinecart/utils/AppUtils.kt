package me.gilo.woodroid.offlinecart.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/*
 *
 */
class AppUtils(internal var context: Context) {
    internal var token: String? = null
    internal var expiry: String? = null

    companion object {
        val currentDateTime: Date
            get() = Calendar.getInstance().time

        fun getFormattedDateString(date: Date?): String? {
            try {
                var spf = SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy")
                val dateString = spf.format(date)
                val newDate = spf.parse(dateString)
                spf = SimpleDateFormat("dd MMM yyyy HH:mm:ss")
                return spf.format(newDate)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return null
        }
    }

}
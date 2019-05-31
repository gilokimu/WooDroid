package me.gilo.woodroid.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Converter {

    fun getDateString(date: Date): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        return sdf.format(date)
    }
}

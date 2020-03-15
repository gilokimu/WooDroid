package me.gilo.woodroid.offlinecart.utils


import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    public fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    public fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}
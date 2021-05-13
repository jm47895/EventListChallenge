package com.jordanmadrigal.event.data.persistence

import androidx.room.TypeConverter
import com.jordanmadrigal.event.data.models.Venue
import com.squareup.moshi.Moshi

class Converters {

    @TypeConverter
    fun fromUserActionLog(data: Venue): String {
        val moshi = Moshi.Builder().build()
        return moshi.adapter(Venue::class.java).toJson(data)
    }

    @TypeConverter
    fun toUserActionLog(json: String): Venue? {
        val moshi = Moshi.Builder().build()
        return moshi.adapter(Venue::class.java).fromJson(json)
    }

}
package com.jordanmadrigal.event.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*


@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey @ColumnInfo(name = "event_id") var eventId : String,

    @field:Json(name = "name")
    @ColumnInfo(name = "name")
    var eventName : String,

    @field:Json(name = "venue")
    @ColumnInfo(name = "venue")
    var eventVenue : Venue,

    @field:Json(name = "url")
    @ColumnInfo(name = "url")
    var eventUrl : String,

    @field:Json(name = "startDate")
    @ColumnInfo(name = "start_date")
    var startDate : String,

    @field:Json(name = "endDate")
    @ColumnInfo(name = "end_date")
    var endDate : String,

    @field:Json(name = "icon")
    @ColumnInfo(name = "icon")
    var icon : String
)

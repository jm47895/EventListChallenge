package com.jordanmadrigal.event.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_table")
data class Event(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "event_id") var eventId : Long,
    @ColumnInfo(name = "name") var eventName : String,
    @ColumnInfo(name = "venue") var eventVenue : String,
    @ColumnInfo(name = "url") var eventUrl : String,
    @ColumnInfo(name = "start_date") var startDate : String,
    @ColumnInfo(name = "end_date") var endDate : String
)

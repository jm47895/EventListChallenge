package com.jordanmadrigal.event.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordanmadrigal.event.data.models.Event

@Database(entities = [Event::class], version = 1, exportSchema = true)
abstract class EventDatabase: RoomDatabase(){
    abstract fun getEventDao(): EventDao
}
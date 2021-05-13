package com.jordanmadrigal.event.repository

import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.data.persistence.EventDatabase
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val cacheDb: EventDatabase
){

    suspend fun insertEventIntoEventCache(event: Event){
        cacheDb.getEventDao().insertEvent(event)
    }
}
package com.jordanmadrigal.event.data.api

import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.data.models.EventList
import retrofit2.Call
import retrofit2.http.GET

interface EventService {

    @GET("service/v2/upcomingGuides/")
    fun getEventList(): Call<EventList>
}
package com.jordanmadrigal.event.data.models

import com.squareup.moshi.Json

data class EventList(

    @field:Json(name = "data")
    var eventList: List<Event>
)

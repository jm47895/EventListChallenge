package com.jordanmadrigal.event.data.models

import com.squareup.moshi.Json

data class Venue(

    @field:Json(name = "city")
    var city : String,

    @field:Json(name = "state")
    var state : String
)

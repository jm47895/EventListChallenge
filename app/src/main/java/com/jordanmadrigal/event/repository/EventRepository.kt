package com.jordanmadrigal.event.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jordanmadrigal.event.data.api.EventService
import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.data.models.EventList
import com.jordanmadrigal.event.data.persistence.EventDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val cacheDb: EventDatabase,
    private val retrofit: Retrofit
){

    private val databaseRequestStatus: MutableLiveData<Boolean> = MutableLiveData()
    private val eventListData: MutableLiveData<List<Event>> = MutableLiveData()

    suspend fun insertEventIntoEventCache(event: Event){
        cacheDb.getEventDao().insertEvent(event)
    }

    fun requestEventList(){
        val service = retrofit.create(EventService::class.java)

        service.getEventList().enqueue(object : Callback<EventList>{
            override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                if(response.isSuccessful){
                    Log.d(TAG, "Response successful: ${response.code()}")

                    databaseRequestStatus.postValue(true)

                    val events: EventList? = response.body()

                    if (events != null) {
                        val eventList = mutableListOf<Event>()
                        for(event in events.eventList){
                            eventList.add(Event(0, event.eventName, event.eventVenue, event.eventUrl, event.startDate, event.endDate, event.icon))
                        }

                        eventListData.value = eventList

                        for(item in eventList){
                            Log.d(TAG, item.toString())
                        }
                    }

                }else{
                    Log.d(TAG, "Response error: ${response.code()}")

                    databaseRequestStatus.postValue(false)
                }
            }

            override fun onFailure(call: Call<EventList>, t: Throwable) {
                databaseRequestStatus.postValue(false)
                Log.d(TAG, "Response failed: ${t.message}")
            }
        })
    }

    fun getRequestStatus():MutableLiveData<Boolean>{
        return databaseRequestStatus
    }

    fun getEventList():MutableLiveData<List<Event>>{
        return eventListData
    }

    companion object{
        private val TAG = EventRepository::class.java.simpleName
    }
}
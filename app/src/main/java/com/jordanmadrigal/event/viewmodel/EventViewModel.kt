package com.jordanmadrigal.event.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.repository.EventRepository
import com.jordanmadrigal.event.ui.EventActivity
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository
): ViewModel(){

    private fun insertEventIntoCache(event: Event){

        viewModelScope.launch {
            eventRepository.insertEventIntoEventCache(event)
        }
    }

    fun requestEventListFromDb(eventActivity: EventActivity) {
        eventRepository.requestEventList()

        eventRepository.getEventList().observe(eventActivity, Observer { eventData ->
            for (event in eventData){
                insertEventIntoCache(event)
            }
        })
    }

    fun getEventList():LiveData<List<Event>>{
        return eventRepository.getEventsInCache().asLiveData()
    }



    fun getRequestStatus():MutableLiveData<Boolean>{
        return eventRepository.getRequestStatus()
    }
}
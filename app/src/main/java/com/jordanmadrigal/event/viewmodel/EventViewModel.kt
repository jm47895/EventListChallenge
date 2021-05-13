package com.jordanmadrigal.event.viewmodel

import androidx.lifecycle.ViewModel
import com.jordanmadrigal.event.data.persistence.EventDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.repository.EventRepository
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository
): ViewModel(){

    fun insertEventIntoCache(event: Event){

        viewModelScope.launch {
            eventRepository.insertEventIntoEventCache(event)
        }
    }
}
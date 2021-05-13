package com.jordanmadrigal.event.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordanmadrigal.event.R
import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.databinding.ActivityEventBinding
import com.jordanmadrigal.event.ui.adapters.EventListAdapter
import com.jordanmadrigal.event.viewmodel.EventViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EventActivity : AppCompatActivity(), EventListAdapter.Interaction{

    private lateinit var binding: ActivityEventBinding
    private lateinit var eventListAdapter: EventListAdapter
    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()

        val eventsList = mutableListOf<Event>()
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))
        eventsList.add(Event(0, "Test", "Test", "Test", "Test", "Test"))

        eventListAdapter.submitList(eventsList)
    }

    private fun initRecyclerView(){
        binding.eventList.apply {
            eventListAdapter = EventListAdapter(this@EventActivity)
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }
    }

    override fun onItemSelected(position: Int, item: Event) {
        Log.d(TAG, "Go to this url: ${item.eventUrl}")
    }

    companion object{
        private val TAG = EventActivity::class.java.simpleName
    }
}
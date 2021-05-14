package com.jordanmadrigal.event.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordanmadrigal.event.R
import com.jordanmadrigal.event.data.models.Event
import com.jordanmadrigal.event.databinding.ActivityEventBinding
import com.jordanmadrigal.event.ui.adapters.EventListAdapter
import com.jordanmadrigal.event.util.AndroidUtils
import com.jordanmadrigal.event.viewmodel.EventViewModel
import dagger.hilt.android.AndroidEntryPoint

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

        showProgressBar()

        requestEventsFromDb()

        initRecyclerView()

        setupObservers()
    }

    private fun requestEventsFromDb() {
        eventViewModel.requestEventListFromDb(this)
    }

    private fun setupObservers() {

        eventViewModel.getRequestStatus().observe(this, Observer { isDataRetrieved->

            if(isDataRetrieved){

                hideProgressBar()

                AndroidUtils.showSnackBar(this, getString(R.string.data_retrieved))

            }else{

                hideProgressBar()

                AndroidUtils.showSnackBar(this, getString(R.string.retrieve_data_error))
            }
        })

        eventViewModel.getEventList().observe(this, Observer { eventListData ->
            eventListAdapter.submitList(eventListData)
        })

    }

    private fun initRecyclerView(){
        binding.eventList.apply {
            eventListAdapter = EventListAdapter(this@EventActivity)
            layoutManager = LinearLayoutManager(context)
            adapter = eventListAdapter
        }
    }

    private fun showProgressBar(){
        binding.loadingBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        binding.loadingBar.visibility = View.INVISIBLE
    }

    override fun onItemSelected(position: Int, item: Event) {
        AndroidUtils.showSnackBar(this, "Navigating to: ${item.eventUrl}")
    }

    companion object{
        private val TAG = EventActivity::class.java.simpleName
    }
}
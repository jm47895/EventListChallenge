package com.jordanmadrigal.event.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jordanmadrigal.event.data.models.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEvent(event: Event): Long


    @Query("SELECT * FROM event_table")
    fun getAllEvents(): Flow<List<Event>>

}
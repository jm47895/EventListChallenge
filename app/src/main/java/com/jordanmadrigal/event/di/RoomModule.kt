package com.jordanmadrigal.event.di

import android.content.Context
import androidx.room.Room
import com.jordanmadrigal.event.data.persistence.EventDao
import com.jordanmadrigal.event.data.persistence.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): EventDatabase {
        return Room.databaseBuilder(
            appContext,
            EventDatabase::class.java,
            "event.db"
        ).build()
    }

    @Provides
    fun provideEventDao(database: EventDatabase) : EventDao{
        return database.getEventDao()
    }
}
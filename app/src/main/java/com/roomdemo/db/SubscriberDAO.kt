package com.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    /*   A function to insert the subscriber object to the database and annotate it with the insert annotation.
    *    Here the name of function is not important. Room library recognizes the fun by the insert annotation not the function name
     *  since we have added the subscriber object as parameter room will recognize that we want to insert subscriber object to the database.
      * Room will generate required code for the task in background.
      * suspend modifier- Room does not support database access on main thread because it might look the ui for long period of time.
      * we need to execute these functions in the background thread. For that we can use async task. the efficient way is kotlin coroutines.
      *since room provides direct support for coroutines, so we writes these function as suspended functions with suspended modifier.
      *suspended function is simply a function that can be paused and resumed later.
      */
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber): Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber): Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscriber(): LiveData<List<Subscriber>>
}
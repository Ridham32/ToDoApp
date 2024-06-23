package com.ridhamsharma.to_doapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Insert
    suspend fun addTask(toDoEntity: ToDoEntity)

    @Delete
    suspend fun delete(toDoEntity: ToDoEntity)

    @Update
    suspend fun Update(toDoEntity: ToDoEntity)

    @Query("SELECT * from ToDoEntity")
    fun getTaskDetails():LiveData<List<ToDoEntity>>

}
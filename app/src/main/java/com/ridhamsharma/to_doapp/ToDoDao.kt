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
    suspend fun deleteTask(toDoEntity: ToDoEntity)

    @Update
    suspend fun updateTask(toDoEntity: ToDoEntity)

    @Query("SELECT * FROM ToDoEntity")
    fun getTaskDetails():LiveData<List<ToDoEntity>>

}
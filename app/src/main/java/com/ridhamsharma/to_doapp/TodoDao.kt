package com.ridhamsharma.to_doapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
 interface TodoDao {

    @Insert
    fun addTodo(listEntity: ListEntity)

     @Query("SELECT * FROM LISTENTITY")
     fun getAllTodo(): LiveData<List<ListEntity>>

     @Delete
     fun deleteTodo(id: Int)
}
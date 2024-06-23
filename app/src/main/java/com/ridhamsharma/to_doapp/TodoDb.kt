package com.ridhamsharma.to_doapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ToDoEntity:: class])
abstract class TodoDb : RoomDatabase() {

    abstract fun todoDao(): ToDoDao

    companion object{
        private var todoDb: TodoDb?= null

        fun getDatabase(context: Context): TodoDb{
            if(todoDb == null){
                todoDb = Room.databaseBuilder(context,TodoDb::class.java,"To-Do App").build()
            }
            return todoDb!!
        }
    }
}
package com.ridhamsharma.to_doapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ToDoEntity:: class], exportSchema = true)
abstract class TodoDb : RoomDatabase() {

    abstract fun todoDao(): ToDoDao

    companion object{
        private var todoDb: TodoDb?= null

        fun getDatabase(context: Context): TodoDb{
            if(todoDb == null){
                todoDb = Room.databaseBuilder(context,TodoDb::class.java,"ToDoApp").build()
            }
            return todoDb!!
        }
    }
}
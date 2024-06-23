package com.ridhamsharma.to_doapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,

    @ColumnInfo
    var taskTodo: String? = null,


)

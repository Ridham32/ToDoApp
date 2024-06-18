package com.ridhamsharma.to_doapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=0,
    @ColumnInfo
    var taskTitle: String?= null


)
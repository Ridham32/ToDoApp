package com.ridhamsharma.to_doapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class TodoViewModel(application: Application): AndroidViewModel(application) {

    var toDoEntity: LiveData<List<ToDoEntity>>
    var todoDao: ToDoDao

    init{

    }
}
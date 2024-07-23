package com.ridhamsharma.to_doapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    var toDoEntity:LiveData<List<ToDoEntity>>
    var todoDao: ToDoDao

    init{
        todoDao =TodoDb.getDatabase(application).todoDao()
        toDoEntity = todoDao.getTaskDetails()
    }


    fun addTasks(toDoEntity: ToDoEntity){
        viewModelScope.launch {
            todoDao.addTask(toDoEntity)
}
    }

    fun deleteTasks(toDoEntity: ToDoEntity){
        viewModelScope.launch {
            todoDao.deleteTask(toDoEntity)
        }
    }

    fun updateTasks(toDoEntity: ToDoEntity){
        viewModelScope.launch {
            todoDao.updateTask(toDoEntity)
        }

    }

}
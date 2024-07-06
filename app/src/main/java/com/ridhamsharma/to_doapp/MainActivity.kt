package com.ridhamsharma.to_doapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridhamsharma.to_doapp.databinding.ActivityMainBinding
import com.ridhamsharma.to_doapp.databinding.DialogboxAddviewBinding
import com.ridhamsharma.to_doapp.databinding.DialogboxEditviewBinding

class MainActivity : AppCompatActivity(), RecyclerInterface {
     var binding: ActivityMainBinding?= null
    lateinit var layoutManager:LinearLayoutManager
    lateinit var viewModel: TodoViewModel
    lateinit var todoDb: TodoDb
    var todoEntityList: ArrayList<ToDoEntity> = ArrayList()
    var adapter: RecyclerViewAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        layoutManager = LinearLayoutManager(this)
        todoDb = TodoDb.getDatabase(this)
        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        adapter = RecyclerViewAdapter(todoEntityList,this)
        binding?.recycler?.layoutManager = layoutManager
        binding?.recycler?.adapter = adapter
        viewModel.toDoEntity.observe(this) {
            adapter?.todoList?.clear()
            adapter?.todoList?.addAll(it)
            adapter?.notifyDataSetChanged()
        }

            binding?.fab?.setOnClickListener{
                var dialog = Dialog(this)
                var dialogBinding = DialogboxAddviewBinding.inflate(layoutInflater)
                dialog.setContentView(dialogBinding.root)
                dialog.getWindow()?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                dialogBinding.btnDlgAdd.setOnClickListener{
                    if(dialogBinding.etDlgMyTask.text.toString().isNullOrEmpty()){
                        dialogBinding.etDlgMyTask.error = "Enter the Task"
                    } else {
                        viewModel.addTasks(ToDoEntity(
                            taskTodo = dialogBinding.etDlgMyTask.text.toString()
                        ))
                        dialog.dismiss()
                    }
                }
                dialog.show()
            }
        }

    override fun onDeleteClick(position: Int) {
        viewModel.deleteTasks(todoEntityList[position])

    }

    override fun onUpdateClick(position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = DialogboxEditviewBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.getWindow()?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialogBinding.btnDlgEdit.setOnClickListener{
            if(dialogBinding.etDlgEditTask.text.toString().isNullOrEmpty()){
                dialogBinding.etDlgEditTask.error = "Enter the task"
            } else {
                viewModel.updateTasks(ToDoEntity(
                    id = todoEntityList[position].id,
                    taskTodo = dialogBinding.etDlgEditTask.text.toString()
                ))
                dialog.dismiss()
            }
        }
        dialog.show()
    }
}
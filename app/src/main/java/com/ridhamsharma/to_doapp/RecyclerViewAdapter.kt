package com.ridhamsharma.to_doapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var todoList: ArrayList<ToDoEntity>,var recyclerInterface: RecyclerInterface): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
       class ViewHolder( view: View):RecyclerView.ViewHolder(view) {
           var tvtask_title = view.findViewById<TextView>(R.id.tvtask_title)
           var ivDelete = view.findViewById<ImageView>(R.id.ivDelete)
       }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listview_activity,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvtask_title.setText(todoList[position].taskTodo)
        holder.ivDelete.setOnClickListener{
            recyclerInterface.onDeleteClick(position)
        }
        holder.tvtask_title.setOnClickListener{
            recyclerInterface.onUpdateClick(position)
        }

    }
}
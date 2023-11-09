package com.example.tasks2ndr.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks2ndr.R
import com.example.tasks2ndr.models.Task
import com.example.tasks2ndr.utils.TaskDiffItemCallback
import com.example.tasks2ndr.databinding.TaskItemBinding


/*
class TaskItemAdapter : RecyclerView.Adapter<TaskItemAdapter.TaskItemViewHolder>() {
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size
 */

class TaskItemAdapter(val clickListener: (taskId: Long) -> Unit ) : ListAdapter<Task, TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallback()){

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        //val item = data[position]
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    //class TaskItemViewHolder(val rootView: TextView)
    //class TaskItemViewHolder(val rootView: CardView)
    //: RecyclerView.ViewHolder(rootView) {
    class TaskItemViewHolder(val binding: TaskItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        //val taskName = rootView.findViewById<TextView>(R.id.task_name)
        //val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)
        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                //val view = layoutInflater.inflate(R.layout.task_item, parent, false) as TextView
                //val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                //return TaskItemViewHolder(view)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskItemViewHolder(binding)
            }
        }

        fun bind(item: Task, clickListener: (taskId: Long) -> Unit) {
            //rootView.text = item.taskName
            //taskName.text = item.taskName
            //taskDone.isChecked = item.taskDone
            binding.task = item
            binding.root.setOnClickListener{ clickListener(item.taskId) }
        }
    }


}
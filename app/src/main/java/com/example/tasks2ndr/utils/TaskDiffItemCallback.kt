package com.example.tasks2ndr.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.tasks2ndr.models.Task

class TaskDiffItemCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task)
        = (oldItem.taskId == newItem.taskId)

    override fun areContentsTheSame(oldItem: Task, newItem: Task)
        = (oldItem == newItem)
}
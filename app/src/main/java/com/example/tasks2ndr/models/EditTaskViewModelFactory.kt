package com.example.tasks2ndr.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasks2ndr.interfaces.TaskDao
import java.lang.IllegalArgumentException

class EditTaskViewModelFactory(private val taskId: Long,
                                private  val dao: TaskDao)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditTaskViewModel::class.java)) {
            return EditTaskViewModel(taskId, dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
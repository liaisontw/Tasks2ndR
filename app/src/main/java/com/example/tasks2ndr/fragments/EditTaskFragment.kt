package com.example.tasks2ndr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.tasks2ndr.R
import com.example.tasks2ndr.databinding.FragmentEditTaskBinding
import com.example.tasks2ndr.models.EditTaskViewModel
import com.example.tasks2ndr.models.EditTaskViewModelFactory
import com.example.tasks2ndr.models.TaskDatabase

class EditTaskFragment : Fragment() {
    private var _binding: FragmentEditTaskBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_edit_task, container, false)
        _binding = FragmentEditTaskBinding.inflate(inflater, container, false)
        val view = _binding!!.root

        val taskId = EditTaskFragmentArgs.fromBundle(requireArguments()).taskId
        //val textView = view.findViewById<TextView>(R.id.task_id)
        //textView.text = taskId.toString()

        val application = requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory =  EditTaskViewModelFactory(taskId, dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(EditTaskViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigateToList.observe(viewLifecycleOwner, Observer {
            navigate -> if (navigate) {
                view.findNavController()
                    .navigate(R.id.action_editTaskFragment_to_tasksFragment)
                viewModel.onNavigatedToList()
            }
        })
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
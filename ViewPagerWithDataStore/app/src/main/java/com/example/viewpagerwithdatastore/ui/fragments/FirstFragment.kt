package com.example.viewpagerwithdatastore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.viewpagerwithdatastore.databinding.FragmentFirstBinding
import com.example.viewpagerwithdatastore.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding!!
    private val myViewModel: MyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)





        binding.saveButton.setOnClickListener {

            val vmName = binding.savename.text
            val vmFood = binding.savefood.text
            val vmAge = binding.saveAge.text

            myViewModel.age.value = vmAge.toString()
            myViewModel.food.value = vmFood.toString()
            myViewModel.name.value = vmName.toString()
            myViewModel.saveData()
        }

        binding.getButton.setOnClickListener {

            myViewModel.retrieveData()

            myViewModel.showTheData().observe(viewLifecycleOwner, Observer {
                binding.getFood.setText(it.food)
                binding.getAge.setText(it.age)
                binding.getName.setText(it.name)
            })

        }

        binding.nextFragmentButton.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding.root
    }
}
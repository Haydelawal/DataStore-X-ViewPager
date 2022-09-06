package com.example.viewpagerwithdatastore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewpagerwithdatastore.databinding.FragmentSecondBinding
import com.example.viewpagerwithdatastore.viewmodel.DS2_ViewModel
import com.example.viewpagerwithdatastore.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var _binding: FragmentSecondBinding
    private val binding get() = _binding!!
    private val myViewModel: MyViewModel by viewModels()
    private val myViewModel2: DS2_ViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        myViewModel.retrieveData()
        myViewModel2.retrieveData()

        myViewModel.showTheData().observe(viewLifecycleOwner, Observer {
            binding.textView.text = it.age
            binding.textView2.text = it.food
        })

        myViewModel2.showTheData().observe(viewLifecycleOwner, Observer {
            binding.textView3.text = it.finished.toString()
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding.root
    }
}
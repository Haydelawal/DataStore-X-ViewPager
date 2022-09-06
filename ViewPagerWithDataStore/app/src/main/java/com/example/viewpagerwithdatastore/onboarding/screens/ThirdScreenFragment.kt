package com.example.viewpagerwithdatastore.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerwithdatastore.R
import com.example.viewpagerwithdatastore.databinding.FragmentFirstScreenBinding
import com.example.viewpagerwithdatastore.databinding.FragmentThirdScreenBinding
import com.example.viewpagerwithdatastore.viewmodel.DS2_ViewModel
import com.example.viewpagerwithdatastore.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenFragment : Fragment() {

    private lateinit var _binding: FragmentThirdScreenBinding
    private val binding get() = _binding!!
    private val myViewModel: DS2_ViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.next.setOnClickListener {

            val viewPagerFinished = true

            myViewModel.finished.value = viewPagerFinished
            myViewModel.saveData()
            myViewModel.retrieveData()

            findNavController().navigate(R.id.action_viewPagerFragment_to_firstFragment)
        }


        binding.previous.setOnClickListener {
            // array, so second fragment = 1
            viewPager?.currentItem = 1
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding.root
    }
}
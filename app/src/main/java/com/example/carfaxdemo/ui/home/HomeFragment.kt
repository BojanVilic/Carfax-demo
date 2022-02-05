package com.example.carfaxdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.carfaxdemo.databinding.FragmentHomeBinding
import com.example.carfaxdemo.generic.adapters.BasicRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.dataContext = homeViewModel

        homeViewModel.getVehicleListings().observe(viewLifecycleOwner, Observer {
            binding.recyclerView.adapter = BasicRecyclerViewAdapter(it, requireContext())
        })


        return binding.root
    }
}
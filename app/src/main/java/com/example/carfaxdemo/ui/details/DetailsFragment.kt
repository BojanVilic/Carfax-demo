package com.example.carfaxdemo.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.carfaxdemo.Constants.VEHICLE_DETAILS_BUNDLE
import com.example.carfaxdemo.databinding.FragmentDetailsBinding
import com.example.carfaxdemo.persistence.VehicleListingDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val detailsViewModel: DetailsViewModel by viewModels()
    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.dataContext = detailsViewModel

        detailsViewModel.vehicleListingDetails = arguments?.get(VEHICLE_DETAILS_BUNDLE) as VehicleListingDetails

        binding.detailsCallDealer.setOnClickListener {
            navigateToNumberDialer()
        }

        return binding.root
    }

    private fun navigateToNumberDialer() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + detailsViewModel.vehicleListingDetails?.phone)
        ContextCompat.startActivity(requireContext(), intent, null)
    }

}
package com.example.carfaxdemo.generic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.carfaxdemo.Constants.VEHICLE_DETAILS_BUNDLE
import com.example.carfaxdemo.R
import com.example.carfaxdemo.databinding.LayoutVehicleListingListItemBinding
import com.example.carfaxdemo.ui.models.VehicleListingDetails

class BasicRecyclerViewAdapter(private val items: List<VehicleListingDetails>) : RecyclerView.Adapter<BasicRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutVehicleListingListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            val bundle = bundleOf()
            bundle.putSerializable(VEHICLE_DETAILS_BUNDLE, items[position])
            it.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
        }

    }

    inner class ViewHolder(private val binding: LayoutVehicleListingListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VehicleListingDetails) {
            binding.dataContext = item
            binding.executePendingBindings()
        }
    }
}
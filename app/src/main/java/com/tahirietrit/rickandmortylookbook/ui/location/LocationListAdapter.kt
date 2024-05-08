package com.tahirietrit.rickandmortylookbook.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.Locations
import com.tahirietrit.rickandmortylookbook.databinding.ItemCharacterListBinding
import com.tahirietrit.rickandmortylookbook.databinding.LocationCardBinding

class LocationListAdapter(val onItemClick: (Locations) -> Unit): RecyclerView.Adapter<LocationListAdapter.ViewHolder>() {

    var locations: List<Locations> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: LocationCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LocationCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locations[position]
        with(holder.binding) {
            planetTextview.text = location.name
            nameTextview.text = location.type
            root.setOnClickListener {
                onItemClick(location)
            }
        }
    }
}
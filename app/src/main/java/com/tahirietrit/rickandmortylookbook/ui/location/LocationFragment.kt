package com.tahirietrit.rickandmortylookbook.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.Location
import com.tahirietrit.rickandmortylookbook.data.model.Locations
import com.tahirietrit.rickandmortylookbook.databinding.FragmentHomeBinding
import com.tahirietrit.rickandmortylookbook.databinding.LocationFragmentBinding
import com.tahirietrit.rickandmortylookbook.ui.home.CharacterListAdapter
import com.tahirietrit.rickandmortylookbook.ui.home.HomeViewModel

class LocationFragment:Fragment() {
    private lateinit var adapter: LocationListAdapter
    private lateinit var binding: LocationFragmentBinding

    val viewModel: LocationViewModel by viewModels<LocationViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LocationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.LocationsList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.locations = it
            }
        }
        adapter = LocationListAdapter(this::onLocationClick)
        binding.LocationList.layoutManager = LinearLayoutManager(requireActivity())
        binding.LocationList.adapter = adapter



    }
    private fun onLocationClick(location: Locations) {
        val action = LocationFragmentDirections.actionLocationListToLocationDetails(location.id.toString())
        findNavController().navigate(action)
    }
}
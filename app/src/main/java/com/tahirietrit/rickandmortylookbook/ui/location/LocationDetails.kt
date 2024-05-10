package com.tahirietrit.rickandmortylookbook.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.LocationDetailsBinding
import com.tahirietrit.rickandmortylookbook.databinding.LocationFragmentBinding
import com.tahirietrit.rickandmortylookbook.ui.episode.EpisodeFragmentArgs
import com.tahirietrit.rickandmortylookbook.ui.home.CharacterListAdapter

class LocationDetails:Fragment() {
//    private lateinit var adapter: LocationListAdapter
    private lateinit var binding: LocationDetailsBinding
    val args: LocationDetailsArgs by navArgs()
    private lateinit var adapter: CharacterListAdapter


    val viewModel: LocationViewModel by viewModels<LocationViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LocationDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLocationById(args.locationId)
        viewModel.getCharactersById(args.locationId)

        viewModel.LocationData.observe(viewLifecycleOwner){location->
            with(binding){
                episodeText.text = location.name
                TypeText.text = "Type"
                DimensionText.text = "Dimension"
                TypeTextView.text = location.type
                DimensionTextView.text = location.dimension

                CastTextView.text = "Residence"

            }

        }
        viewModel.characterData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.characters = it
            }
        }
        adapter  = CharacterListAdapter(this::clickListener)
        binding.CastRecy.layoutManager = LinearLayoutManager(requireActivity())
        binding.CastRecy.adapter = adapter

        viewModel
    }
    private fun clickListener(character: Character){
        val action = LocationDetailsDirections.actionLocationDetailsToFragmentDetail(character.id.toString())
        findNavController().navigate(action)
    }
}
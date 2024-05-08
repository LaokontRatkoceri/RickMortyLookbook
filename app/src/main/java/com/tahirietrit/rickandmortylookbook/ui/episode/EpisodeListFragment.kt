package com.tahirietrit.rickandmortylookbook.ui.episode

import Episode
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
import com.tahirietrit.rickandmortylookbook.data.model.EpisodesRes
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeDetailsBinding
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeListBinding
import com.tahirietrit.rickandmortylookbook.ui.home.CharacterListAdapter
import com.tahirietrit.rickandmortylookbook.ui.location.LocationDetailsDirections

class EpisodeListFragment:Fragment() {
    lateinit var binding: EpisodeListBinding
    val viewModel: EpisodeDetailView by viewModels<EpisodeDetailView>()
    private lateinit var adapter: EpisodeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EpisodeListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EpisodeListAdapter(this::clickListener)
        binding.episodeRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.episodeRecycler.adapter = adapter
        viewModel.episodesList.observe(viewLifecycleOwner) {
            adapter.episodes = it
        }
    }

    private fun clickListener(episode: EpisodesRes){
        val action = EpisodeListFragmentDirections.actionEpisdoeListToEpisodeDetail(episode.id.toString())
        findNavController().navigate(action)
    }
}
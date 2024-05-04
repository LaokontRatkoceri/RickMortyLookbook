package com.tahirietrit.rickandmortylookbook.ui.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeDetailsBinding

import com.tahirietrit.rickandmortylookbook.ui.home.CharacterListAdapter


class EpisodeFragment:Fragment() {
    lateinit var binding: EpisodeDetailsBinding
    val viewModel: EpisodeDetailView by viewModels()
    private lateinit var adapter: CharacterListAdapter
    val args: EpisodeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EpisodeDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getEpisodById(args.episodeId)
        viewModel.getCharactersById(args.episodeId)
        viewModel.episodeData.observe(viewLifecycleOwner) {episode->
            with(binding){
                episodeText.text = episode.name
                DateNameText.text = "Date"
                dateTextView.text = episode.airDate
                EpisodeText.text = "Episode"
                EpisodeTextView.text = episode.episode

            }
        }
        viewModel.characterData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.characters = it
                println("{Rick}")
            }
        }

        adapter = CharacterListAdapter(this::clickListener)
        binding.CastRecy.layoutManager = LinearLayoutManager(requireActivity())
        binding.CastRecy.adapter = adapter


    }
    fun clickListener(character: Character){

    }

}
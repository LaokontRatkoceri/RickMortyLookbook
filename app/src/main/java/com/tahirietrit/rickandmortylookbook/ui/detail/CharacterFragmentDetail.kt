package com.tahirietrit.rickandmortylookbook.ui.detail

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
import com.squareup.picasso.Picasso
import com.tahirietrit.rickandmortylookbook.databinding.FragmentCharacterDetailBinding
import com.tahirietrit.rickandmortylookbook.ui.episode.EpisodesAdapter
import com.tahirietrit.rickandmortylookbook.util.CircularTransformation

class CharacterFragmentDetail : Fragment() {
    val viewModel : CharacterDetailViewModel by viewModels()
    private  lateinit var adapter: EpisodesAdapter
    lateinit var binding: FragmentCharacterDetailBinding
    val args: CharacterFragmentDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacterById(args.characterId)
        viewModel.getEpisodes(args.characterId)
        viewModel.characterData.observe(viewLifecycleOwner){character->
            with(binding){
                characterName.text = character.name
                infoGender.infoHeader.text = "Gender"
                infoGender.infoData.text = character.gender
                infoStatus.infoHeader.text = "Status"
                infoStatus.infoData.text = character.status
                infoSpecie.infoHeader.text = "Header"
                infoSpecie.infoData.text = character.species
                infoOrigin.infoHeader.text = "Origin"
                infoOrigin.infoData.text = character.origin?.name
                infoType.infoHeader.text = "Type"
                if (character.type.equals("")) {
                    infoType.infoData.text = "Human"
                } else {
                    infoType.infoData.text = character.type
                }
                //            binding.infoType.infoData.text = it.type
                infoLocation.infoHeader.text = "Location"
                infoLocation.infoData.text = character.location?.name
                Picasso.get().load(character.image.toString()).transform(CircularTransformation()).into(binding.characterAvatar)
            }


            viewModel.episodeData.observe(viewLifecycleOwner){
                if (it != null){
                    adapter.episode = it
                }
            }
            adapter = EpisodesAdapter(this::onEpisodeClick)
            binding.episodeRecycler.layoutManager = LinearLayoutManager(requireActivity())
            binding.episodeRecycler.adapter = adapter
        }
    }
    private fun onEpisodeClick(episode: Episode) {
        val action = CharacterFragmentDetailDirections.EpisodeDetailAction(episode.id.toString())
        findNavController().navigate(action)
    }

}
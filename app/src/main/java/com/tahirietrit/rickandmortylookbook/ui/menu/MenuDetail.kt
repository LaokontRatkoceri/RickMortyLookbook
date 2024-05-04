package com.tahirietrit.rickandmortylookbook.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.tahirietrit.rickandmortylookbook.R
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.FragmentCharacterDetailBinding
import com.tahirietrit.rickandmortylookbook.databinding.MenuFragmentBinding
import com.tahirietrit.rickandmortylookbook.ui.detail.CharacterDetailViewModel
import com.tahirietrit.rickandmortylookbook.ui.detail.CharacterFragmentDetail
import com.tahirietrit.rickandmortylookbook.ui.detail.CharacterFragmentDetailArgs
import com.tahirietrit.rickandmortylookbook.ui.episode.EpisodesAdapter
import com.tahirietrit.rickandmortylookbook.ui.home.HomeFragmentDirections
import com.tahirietrit.rickandmortylookbook.util.CircularTransformation

class MenuDetail:Fragment() {
    val viewModel : MenuViewModel by viewModels()
    lateinit var binding: MenuFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.chracterTextView.text = "Characters"
            binding.EpisodeTextView.text = "Episodes"
            binding.LocationTextView.text = "Location"

            binding.chracterTextView.setOnClickListener {
                findNavController().navigate(R.id.action_MenuDetail_to_homeFragment2)

            }
            binding.EpisodeTextView.setOnClickListener {
                findNavController().navigate(R.id.action_MenuDetail_to_EpisdoeList)

            }

        }
    }


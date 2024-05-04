package com.tahirietrit.rickandmortylookbook.ui.home

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahirietrit.rickandmortylookbook.R
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private lateinit var adapter: CharacterListAdapter
    private lateinit var binding: FragmentHomeBinding

    val viewModel: HomeViewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.charactersList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.characters = it
            }
        }
        adapter = CharacterListAdapter(this::onCharacterClick)
        binding.characterList.layoutManager = LinearLayoutManager(requireActivity())
        binding.characterList.adapter = adapter




    }

    private fun onCharacterClick(character: Character) {
        val action = HomeFragmentDirections.openDetailFragment(character.id.toString())
        findNavController().navigate(action)
    }

}
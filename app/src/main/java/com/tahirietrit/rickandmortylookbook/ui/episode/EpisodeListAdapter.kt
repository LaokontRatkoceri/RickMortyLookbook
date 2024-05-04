package com.tahirietrit.rickandmortylookbook.ui.episode

import Episode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahirietrit.rickandmortylookbook.data.model.Episodes
import com.tahirietrit.rickandmortylookbook.data.model.EpisodesRes
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeCardBinding
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeDetailsBinding
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeListBinding
import com.tahirietrit.rickandmortylookbook.databinding.ItemCharacterListBinding
import com.tahirietrit.rickandmortylookbook.ui.home.CharacterListAdapter
//val onItemClick: (Episode) -> Unit
class EpisodeListAdapter :
    RecyclerView.Adapter<EpisodeListAdapter.ViewHolder>() {

    var episodes: List<EpisodesRes> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: EpisodeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            EpisodeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeListAdapter.ViewHolder, position: Int) {
        val episodes = episodes[position]
        with(holder.binding){
            episodenameTextview.text = episodes.name
            episodedateTextview.text = episodes.airDate
            episodeText.text = episodes.episode
        }

    }

    override fun getItemCount(): Int = episodes.size


}
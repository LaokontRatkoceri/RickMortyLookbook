package com.tahirietrit.rickandmortylookbook.ui.detail

import Episode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.EpisodeItemBinding

class EpisodesAdapter(val onItemClick: (Episode) -> Unit): RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    var episode : List<Episode> = emptyList()
        set(value)  {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder (val binding: EpisodeItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EpisodeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = episode.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val episode = episode[position]
        with(holder.binding){
            episodedateTextview.text = episode.airDate
            episodenameTextview.text = episode.name
            listEpisode.text = episode.episode
            root.setOnClickListener{
                onItemClick(episode)
            }
        }

    }
}
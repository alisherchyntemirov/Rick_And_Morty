package com.example.rick_and_morty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_and_morty.common.base.BaseComparator
import com.example.rick_and_morty.data.network.dto.episode.EpisodeDto
import com.example.rick_and_morty.databinding.ItemEpisodeBinding

class EpisodeAdapter(
    private val onItemClick: (id: Int) -> Unit,
) : PagingDataAdapter<EpisodeDto, EpisodeAdapter.EpisodeViewHolder>(
    BaseComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).apply {
                    onItemClick(this!!.id)
                }
            }
        }

        fun onBind(item: EpisodeDto) = with(binding) {
            itemName.text = item.name
            itemAirDate.text = item.air_date
        }
    }
}
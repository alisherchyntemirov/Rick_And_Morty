package com.example.rick_and_morty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rick_and_morty.R
import com.example.rick_and_morty.common.base.BaseComparator
import com.example.rick_and_morty.data.network.dto.character.CharacterDto
import com.example.rick_and_morty.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val onItemClick: (id: Int) -> Unit,
    private val onItemLongClick: (image: String) -> Unit
) : PagingDataAdapter<CharacterDto, CharacterAdapter.CharacterViewHolder>(
    BaseComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).apply {
                    onItemClick(this!!.id)
                }
            }
        }

        init {
            itemView.setOnLongClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemLongClick(it.image)
                }
                return@setOnLongClickListener false
            }
        }

        fun onBind(item: CharacterDto) = with(binding) {
            itemImage.load(item.image)
            itemNm.text = item.name
            itemStatus.text = item.status
            itemSpecies.text = item.species
            locationItem.text = item.location.name
            when (item.status) {
                "Alive" -> itemStatusLv.setBackgroundResource(R.drawable.circle_live)
                "Dead" -> itemStatusLv.setBackgroundResource(R.drawable.circle_dead)
                else -> itemStatusLv.setBackgroundResource(R.drawable.circle_unkown)
            }
        }
    }
}
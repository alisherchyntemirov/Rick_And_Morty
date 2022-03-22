package com.example.rick_and_morty.ui.fragment.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rick_and_morty.common.base.BaseViewModel
import com.example.rick_and_morty.data.repository.EpisodeRepository

class EpisodeViewModel constructor(
    private val repository: EpisodeRepository
) : BaseViewModel() {
    fun fetchEpisode() = repository.fetchEpisodes().cachedIn(viewModelScope)
}
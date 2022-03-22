package com.example.rick_and_morty.ui.fragment.episode.episodesDetail

import com.example.rick_and_morty.common.base.BaseViewModel
import com.example.rick_and_morty.data.network.dto.episode.EpisodeDto
import com.example.rick_and_morty.data.repository.EpisodeRepository
import com.example.rick_and_morty.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EpisodesDetailViewModel constructor(
    private val repository: EpisodeRepository
) : BaseViewModel() {
    private val _episodeState = MutableStateFlow<UIState<EpisodeDto>>(UIState.Loading())
    var episodeState: StateFlow<UIState<EpisodeDto>> = _episodeState

    fun fetchEpisode(id: Int) {
        _episodeState.subscribeTo {
            repository.fetchEpisode(id)
        }
    }
}
package com.example.rick_and_morty.data.network.paginsources

import com.example.rick_and_morty.common.base.BasePagingSource
import com.example.rick_and_morty.data.network.api.EpisodeApiService
import com.example.rick_and_morty.data.network.dto.episode.EpisodeDto

class EpisodePagingSource(
    private val service: EpisodeApiService
) : BasePagingSource<EpisodeDto>({ position ->
    service.fetchEpisodes(position)
})
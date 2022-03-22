package com.example.rick_and_morty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rick_and_morty.common.base.BaseRepository
import com.example.rick_and_morty.data.network.api.EpisodeApiService
import com.example.rick_and_morty.data.network.dto.episode.EpisodeDto
import com.example.rick_and_morty.data.network.paginsources.EpisodePagingSource
import kotlinx.coroutines.flow.Flow

class EpisodeRepository constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

    fun fetchEpisodes(): Flow<PagingData<EpisodeDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).flow
    }
    fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id)
    }
}
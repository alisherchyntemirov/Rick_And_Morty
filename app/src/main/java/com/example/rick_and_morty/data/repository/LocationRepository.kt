package com.example.rick_and_morty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rick_and_morty.common.base.BaseRepository
import com.example.rick_and_morty.data.network.api.LocationApiService
import com.example.rick_and_morty.data.network.dto.location.LocationDto
import com.example.rick_and_morty.data.network.paginsources.LocationPagingSource
import kotlinx.coroutines.flow.Flow

class LocationRepository  constructor(
    private val service: LocationApiService
) : BaseRepository() {

    fun fetchLocations(): Flow<PagingData<LocationDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                LocationPagingSource(service)
            }
        ).flow
    }

    fun fetchLocation(id: Int) = doRequest {
        service.fetchLocation(id)
    }
}
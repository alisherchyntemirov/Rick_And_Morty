package com.example.rick_and_morty.data.network.paginsources

import com.example.rick_and_morty.common.base.BasePagingSource
import com.example.rick_and_morty.data.network.api.LocationApiService
import com.example.rick_and_morty.data.network.dto.location.LocationDto

class LocationPagingSource(
    private val service: LocationApiService
) : BasePagingSource<LocationDto>({ position ->
    service.fetchLocations(position)
})
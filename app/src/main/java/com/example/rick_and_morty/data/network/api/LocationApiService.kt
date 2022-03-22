package com.example.rick_and_morty.data.network.api

import com.example.rick_and_morty.data.network.dto.RickAndMortyResponse
import com.example.rick_and_morty.data.network.dto.location.LocationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("/api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): RickAndMortyResponse<LocationDto>

    @GET("/api/location/{id}")
    suspend fun fetchLocation(
        @Path("id") id: Int
    ): LocationDto
}
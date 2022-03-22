package com.example.rick_and_morty.ui.fragment.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rick_and_morty.common.base.BaseViewModel
import com.example.rick_and_morty.data.repository.LocationRepository

class LocationViewModel constructor(
    private val repository: LocationRepository
) : BaseViewModel() {
    fun fetchLocations() = repository.fetchLocations().cachedIn(viewModelScope)
}
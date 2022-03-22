package com.example.rick_and_morty.ui.fragment.character

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rick_and_morty.common.base.BaseViewModel
import com.example.rick_and_morty.data.repository.CharacterRepository

class CharacterViewModel constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)
}
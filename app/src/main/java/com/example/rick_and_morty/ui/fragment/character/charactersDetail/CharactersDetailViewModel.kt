package com.example.rick_and_morty.ui.fragment.character.charactersDetail

import com.example.rick_and_morty.common.base.BaseViewModel
import com.example.rick_and_morty.data.network.dto.character.CharacterDto
import com.example.rick_and_morty.data.repository.CharacterRepository
import com.example.rick_and_morty.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CharactersDetailViewModel constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    private val _characterState = MutableStateFlow<UIState<CharacterDto>>(UIState.Loading())
    var characterState: StateFlow<UIState<CharacterDto>> = _characterState

    fun fetchCharacter(id: Int) {
        _characterState.subscribeTo {
            repository.fetchCharacter(id)
        }
    }
}
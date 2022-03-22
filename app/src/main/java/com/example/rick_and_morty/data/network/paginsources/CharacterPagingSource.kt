package com.example.rick_and_morty.data.network.paginsources

import com.example.rick_and_morty.common.base.BasePagingSource
import com.example.rick_and_morty.data.network.api.CharacterApiService
import com.example.rick_and_morty.data.network.dto.character.CharacterDto

class CharacterPagingSource (
    private val service: CharacterApiService
) : BasePagingSource<CharacterDto>({ position ->
    service.fetchCharacters(position)
})
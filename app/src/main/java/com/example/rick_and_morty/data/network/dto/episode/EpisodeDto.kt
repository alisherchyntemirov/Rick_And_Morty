package com.example.rick_and_morty.data.network.dto.episode

import com.example.rick_and_morty.common.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val characters: MutableList<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : IBaseDiffModel
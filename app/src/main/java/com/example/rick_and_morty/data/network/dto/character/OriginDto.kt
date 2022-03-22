package com.example.rick_and_morty.data.network.dto.character

import com.google.gson.annotations.SerializedName

class OriginDto (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
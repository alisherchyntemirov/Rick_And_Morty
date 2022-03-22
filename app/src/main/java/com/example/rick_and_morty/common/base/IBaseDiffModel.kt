package com.example.rick_and_morty.common.base

interface IBaseDiffModel {
    val id: Int
    override fun equals(other: Any?): Boolean
}
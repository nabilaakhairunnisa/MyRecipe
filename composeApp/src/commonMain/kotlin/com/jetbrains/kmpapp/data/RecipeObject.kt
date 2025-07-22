package com.jetbrains.kmpapp.data

import kotlinx.serialization.Serializable

@Serializable
data class RecipeObject(
    val id: Int,
    val title: String,
    val imgUrl: String,
    val ingredients: List<String>,
    val howToCook: List<String>,
)
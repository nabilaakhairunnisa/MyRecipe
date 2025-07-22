package com.jetbrains.kmpapp.screens.detail

import androidx.lifecycle.ViewModel
import com.jetbrains.kmpapp.data.RecipeObject
import com.jetbrains.kmpapp.data.RecipeRepository
import kotlinx.coroutines.flow.Flow

class DetailViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    fun getObject(objectId: Int): Flow<RecipeObject?> =
        recipeRepository.getObjectById(objectId)
}

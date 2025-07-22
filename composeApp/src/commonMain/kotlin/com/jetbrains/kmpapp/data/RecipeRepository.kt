package com.jetbrains.kmpapp.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RecipeRepository(
    private val recipeApi: RecipeApi,
    private val recipeStorage: RecipeStorage,
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        recipeStorage.saveObjects(recipeApi.getData())
    }

    fun getObjects(): Flow<List<RecipeObject>> = recipeStorage.getObjects()

    fun getObjectById(objectId: Int): Flow<RecipeObject?> = recipeStorage.getObjectById(objectId)
}

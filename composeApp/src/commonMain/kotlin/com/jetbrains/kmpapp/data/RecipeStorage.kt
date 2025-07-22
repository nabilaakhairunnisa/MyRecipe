package com.jetbrains.kmpapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface RecipeStorage {
    suspend fun saveObjects(newObjects: List<RecipeObject>)

    fun getObjectById(objectId: Int): Flow<RecipeObject?>

    fun getObjects(): Flow<List<RecipeObject>>
}

class InMemoryRecipeStorage : RecipeStorage {
    private val storedObjects = MutableStateFlow(emptyList<RecipeObject>())

    override suspend fun saveObjects(newObjects: List<RecipeObject>) {
        storedObjects.value = newObjects
    }

    override fun getObjectById(objectId: Int): Flow<RecipeObject?> {
        return storedObjects.map { objects ->
            objects.find { it.id == objectId }

        }
    }

    override fun getObjects(): Flow<List<RecipeObject>> = storedObjects
}

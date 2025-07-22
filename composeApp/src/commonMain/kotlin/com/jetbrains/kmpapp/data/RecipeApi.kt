package com.jetbrains.kmpapp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.utils.io.CancellationException

interface RecipeApi {
    suspend fun getData(): List<RecipeObject>
    suspend fun addData(newData: RecipeObject): Boolean
}

class KtorRecipeApi(private val client: HttpClient) : RecipeApi {
    companion object {
        private const val API_URL =
            "https://apigenerator.dronahq.com/api/FKrOL8SO/recipe"
    }

    override suspend fun getData(): List<RecipeObject> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
    }

    override suspend fun addData(newData: RecipeObject): Boolean {
        return try {
            client.post(API_URL) {
                contentType(io.ktor.http.ContentType.Application.Json)
                setBody(newData)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}

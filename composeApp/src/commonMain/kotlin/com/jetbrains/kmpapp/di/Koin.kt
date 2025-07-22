package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.data.InMemoryRecipeStorage
import com.jetbrains.kmpapp.data.KtorRecipeApi
import com.jetbrains.kmpapp.data.RecipeApi
import com.jetbrains.kmpapp.data.RecipeRepository
import com.jetbrains.kmpapp.data.RecipeStorage
import com.jetbrains.kmpapp.screens.detail.DetailViewModel
import com.jetbrains.kmpapp.screens.list.ListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<RecipeApi> { KtorRecipeApi(get()) }
    single<RecipeStorage> { InMemoryRecipeStorage() }
    single {
        RecipeRepository(get(), get()).apply {
            initialize()
        }
    }
}

val viewModelModule = module {
    factoryOf(::ListViewModel)
    factoryOf(::DetailViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelModule,
        )
    }
}

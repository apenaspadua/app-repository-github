package com.padua.githubrepository.data.di

import android.util.Log
import com.padua.githubrepository.data.model.Repo
import com.padua.githubrepository.data.repository.RepoRepository
import com.padua.githubrepository.data.repository.RepoRepositoryImpl
import com.padua.githubrepository.data.services.RepositoriesListMostStarsService
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DataModule {
    private const val BASE_URL = "https://api.github.com/search/"
    private const val OK_HTTP = "Ok Http"

    fun load() {
        loadKoinModules(reposModule() + networkModule())
    }

    private fun reposModule(): Module {
        return module {
            single<RepoRepository> { RepoRepositoryImpl(get()) }
        }
    }

    private fun networkModule(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor{
                    Log.e(OK_HTTP, it, )
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
                Moshi
                    .Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            }

            single {
                createService<RepositoriesListMostStarsService>(get(), get())
            }
        }
    }

    private inline fun <reified T> createService(
        client: OkHttpClient,
        factory: Moshi,
    ) : T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(factory))
            .build()
            .create(T::class.java)
    }
}



package com.padua.githubrepository.data.services

import com.padua.githubrepository.data.model.Repo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface RepositoriesListMostStarsService {

    @GET("repositories?q=language:kotlin&sort=stars")
    suspend fun listRepos(): Repo
}
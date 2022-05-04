package com.padua.githubrepository.data.repository

import com.padua.githubrepository.data.model.Repo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface RepoRepository {
    suspend fun listRepos(): Flow<Repo>
}
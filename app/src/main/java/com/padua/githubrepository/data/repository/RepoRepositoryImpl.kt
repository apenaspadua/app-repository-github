package com.padua.githubrepository.data.repository

import com.padua.githubrepository.data.model.Repo
import com.padua.githubrepository.data.services.RepositoriesListMostStarsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call


class RepoRepositoryImpl(private val service: RepositoriesListMostStarsService): RepoRepository {

    override suspend fun listRepos(): Flow<Repo> = flow {
       val repoList = service.listRepos()
        emit(repoList)
    }
}
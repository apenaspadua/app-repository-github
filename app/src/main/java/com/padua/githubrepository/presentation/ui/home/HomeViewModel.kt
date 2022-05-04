package com.padua.githubrepository.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.padua.githubrepository.data.model.Repo
import com.padua.githubrepository.data.repository.RepoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: RepoRepository): ViewModel() {

    private val _listRepo = MutableLiveData<Repo>()
    val listRepo: LiveData<Repo> get() = _listRepo

    init {
        fetchRepos()
    }

    private fun fetchRepos() {
        viewModelScope.launch {
            repository.listRepos().collect {
                _listRepo.value = it
            }
        }
    }
}

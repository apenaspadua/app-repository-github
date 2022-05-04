package com.padua.githubrepository.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padua.githubrepository.data.model.Repo
import com.padua.githubrepository.databinding.HomeFragmentBinding
import com.padua.githubrepository.presentation.adapter.RepoListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private val binding: HomeFragmentBinding by lazy {
        HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initBinding()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val adapter = RepoListAdapter()
        binding.homeRv.adapter = adapter

        viewModel.listRepo.observe(viewLifecycleOwner) {
          adapter.submitList(it.items)
        }
    }

    private fun initBinding() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
package com.padua.githubrepository.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.padua.githubrepository.data.model.Repo
import com.padua.githubrepository.databinding.ItemRepoBinding

class RepoListAdapter: ListAdapter<Repo.Item, RepoListAdapter.RepoViewHolder>(RepoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RepoViewHolder(private val binding: ItemRepoBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup) : RepoViewHolder {
                val binding: ItemRepoBinding = ItemRepoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RepoViewHolder(binding)
            }
        }

        fun bind(item: Repo.Item) {
            binding.repo = item
        }
    }

    private class RepoDiffCallback : DiffUtil.ItemCallback<Repo.Item>(){
        override fun areItemsTheSame(oldItem: Repo.Item, newItem: Repo.Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repo.Item, newItem: Repo.Item): Boolean {
            return oldItem == newItem
        }

    }
}
package com.padua.githubrepository.presentation.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.padua.githubrepository.data.model.Repo
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

@BindingAdapter("imageProfile")
fun ImageView.setImageProfile(repo: Repo.Item) {
    repo.let {

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

//        Glide.with(this).load(repo)
//            .placeholder(circularProgressDrawable).into(this)
    }
}

@BindingAdapter("repoName")
fun TextView.setRepoName(repo: Repo.Item) {
    repo.let {
        text = it.name
    }
}

@BindingAdapter("authorName")
fun TextView.setAuthorName(repo: Repo.Item) {
    repo.let {
        text = it.full_name
    }
}

@BindingAdapter("numberStars")
fun TextView.setNumberStars(repo: Repo.Item) {
    repo.let {
        text = it.stargazers_count.toString()
    }
}

@BindingAdapter("numberForks")
fun TextView.setNumberForks(repo: Repo.Item) {
    repo.let {
        text = it.forks_count.toString()
    }
}
package com.example.testmoviereviewapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testmoviereviewapp.domain.model.MovieModel

class MoviesDiffCallback : DiffUtil.ItemCallback<MovieModel>() {

    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem == newItem
    }
}
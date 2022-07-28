package com.example.testmoviereviewapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import coil.load
import com.example.testmoviereviewapp.databinding.ItemMovieBinding
import com.example.testmoviereviewapp.domain.model.MovieModel

class MoviesAdapter : PagingDataAdapter<MovieModel, MoviesViewHolder>(MoviesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)!!
        with(holder.binding) {
            title.text = movie.title
            description.text = movie.description
            movieImage.load(movie.multimedia.image)
        }
    }

}
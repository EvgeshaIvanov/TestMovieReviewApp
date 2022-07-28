package com.example.testmoviereviewapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testmoviereviewapp.databinding.ItemMovieBinding
import com.example.testmoviereviewapp.domain.model.MovieModel

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    var moviesList = emptyList<MovieModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        with(holder.binding) {
            title.text = movie.title
            description.text = movie.description
            movieImage.load(movie.multimedia.image)
        }
    }

    override fun getItemCount() = moviesList.size

}
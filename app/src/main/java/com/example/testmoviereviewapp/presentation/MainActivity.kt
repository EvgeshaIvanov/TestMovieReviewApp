package com.example.testmoviereviewapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmoviereviewapp.app.MoviesApp
import com.example.testmoviereviewapp.databinding.ActivityMainBinding
import com.example.testmoviereviewapp.presentation.adapter.MoviesAdapter
import com.example.testmoviereviewapp.presentation.viewmodel.MoviesViewModel
import com.example.testmoviereviewapp.presentation.viewmodel.MoviesViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var moviesAdapter: MoviesAdapter

    lateinit var moviesViewModel: MoviesViewModel

    @Inject
    lateinit var viewModelFactory: MoviesViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MoviesApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
    }

    private fun initViewModel() {
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
        moviesViewModel.moviesList.observe(this@MainActivity) { movies ->
            lifecycleScope.launch {
                moviesAdapter.submitData(movies)
            }
        }
    }

    private fun initRecyclerView() {
        moviesAdapter = MoviesAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = moviesAdapter
        }
    }
}


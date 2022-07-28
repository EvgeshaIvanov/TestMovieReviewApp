package com.example.testmoviereviewapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmoviereviewapp.databinding.ActivityMainBinding
import com.example.testmoviereviewapp.presentation.adapter.MoviesAdapter
import com.example.testmoviereviewapp.presentation.viewmodel.MoviesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var moviesAdapter: MoviesAdapter

    lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        initViewModel()
    }

    private fun initViewModel() {
        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        lifecycleScope.launch {
            moviesViewModel.flow.collectLatest { movies ->
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


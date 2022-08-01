package com.example.testmoviereviewapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testmoviereviewapp.data.network.ApiService
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.utils.Constants.MOVIES_ITEMS
import com.example.testmoviereviewapp.utils.Constants.PAGE


class MoviesPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, MovieModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val pageIndex = params.key ?: PAGE
        return try {
            val response = apiService.moviesReviews(pageIndex)
            val movies = response.movieModel
            return LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == 0) null else pageIndex - 20,
                nextKey = if (movies.size < MOVIES_ITEMS) null else pageIndex + 20
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

}
package com.example.testmoviereviewapp.presentation.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase

private const val PAGE = 0
private const val MOVIES_ITEMS = 20

class MoviesPagingSource(
    private val useCase: MoviesReviewsUseCase
) : PagingSource<Int, MovieModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val pageIndex = params.key ?: PAGE
        return try {
            val response = useCase.execute(page = pageIndex)
            return LoadResult.Page(
                data = response,
                prevKey = if (pageIndex == 0) null else pageIndex - 1,
                nextKey = if (response.size < MOVIES_ITEMS) null else pageIndex + 1
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
package com.example.inehemias.mvvmmovieapp.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.inehemias.mvvmmovieapp.data.api.POST_PER_PAGE
import com.example.inehemias.mvvmmovieapp.data.api.TheMovieDBInterface
import com.example.inehemias.mvvmmovieapp.data.repository.MovieDataSource
import com.example.inehemias.mvvmmovieapp.data.repository.MovieDataSourceFactory
import com.example.inehemias.mvvmmovieapp.data.repository.NetworkState
import com.example.inehemias.mvvmmovieapp.data.viewController.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository(private val apiService: TheMovieDBInterface) {

    private lateinit var moviePagedList: LiveData<PagedList<Movie>>
    private lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState
        )
    }
}
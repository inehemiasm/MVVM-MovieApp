package com.example.inehemias.mvvmmovieapp.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.inehemias.mvvmmovieapp.data.api.TheMovieDBInterface
import com.example.inehemias.mvvmmovieapp.data.repository.MovieDetailsNetworkDataSource
import com.example.inehemias.mvvmmovieapp.data.repository.NetworkState
import com.example.inehemias.mvvmmovieapp.data.viewController.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    private lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}
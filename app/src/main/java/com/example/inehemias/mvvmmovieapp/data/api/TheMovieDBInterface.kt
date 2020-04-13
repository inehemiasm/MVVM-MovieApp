package com.example.inehemias.mvvmmovieapp.data.api


import com.example.inehemias.mvvmmovieapp.data.viewController.MovieDetails
import com.example.inehemias.mvvmmovieapp.data.viewController.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}
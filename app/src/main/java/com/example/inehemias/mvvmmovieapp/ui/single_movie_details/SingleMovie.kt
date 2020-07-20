package com.example.inehemias.mvvmmovieapp.ui.single_movie_details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.inehemias.mvvmmovieapp.R
import com.example.inehemias.mvvmmovieapp.data.api.POSTER_BASE_URL
import com.example.inehemias.mvvmmovieapp.data.api.TheMovieDBClient
import com.example.inehemias.mvvmmovieapp.data.api.TheMovieDBInterface
import com.example.inehemias.mvvmmovieapp.data.repository.NetworkState
import com.example.inehemias.mvvmmovieapp.data.viewController.MovieDetails
import java.text.NumberFormat
import java.util.Locale
import kotlinx.android.synthetic.main.activity_single_movie.iv_movie_poster
import kotlinx.android.synthetic.main.activity_single_movie.movie_budget
import kotlinx.android.synthetic.main.activity_single_movie.movie_overview
import kotlinx.android.synthetic.main.activity_single_movie.movie_rating
import kotlinx.android.synthetic.main.activity_single_movie.movie_release_date
import kotlinx.android.synthetic.main.activity_single_movie.movie_revenue
import kotlinx.android.synthetic.main.activity_single_movie.movie_runtime
import kotlinx.android.synthetic.main.activity_single_movie.movie_tagline
import kotlinx.android.synthetic.main.activity_single_movie.movie_title
import kotlinx.android.synthetic.main.activity_single_movie.progress_bar
import kotlinx.android.synthetic.main.activity_single_movie.txt_error

class SingleMovie : AppCompatActivity() {

    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepository: MovieDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)

        val movieId: Int = intent.getIntExtra("id", 1)

        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient(this.applicationContext)
        movieRepository = MovieDetailsRepository(apiService)

        viewModel = getViewModel(movieId)

        viewModel.movieDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADED) View.GONE else View.VISIBLE
            txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE
        })
    }

    private fun bindUI(it: MovieDetails) {
        movie_title.text = it.title
        movie_tagline.text = it.tagline
        movie_release_date.text = it.releaseDate
        movie_rating.text = it.rating.toString()
        movie_runtime.text = "${it.runtime} minutes"
        movie_overview.text = it.overview

        val formatCurrency = NumberFormat.getCurrencyInstance(Locale.US)
        movie_budget.text = formatCurrency.format(it.budget)
        movie_revenue.text = formatCurrency.format(it.revenue)

        val moviePosterURL = POSTER_BASE_URL + it.posterPath
        Glide.with(this)
            .load(moviePosterURL)
            .into(iv_movie_poster)
    }

    private fun getViewModel(movieId: Int): SingleMovieViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleMovieViewModel(movieRepository, movieId) as T
            }
        })[SingleMovieViewModel::class.java]
    }
}

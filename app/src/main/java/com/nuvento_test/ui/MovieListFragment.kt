package com.nuvento_test.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuvento_test.data.model.Search
import com.nuvento_test.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MovieListFragment :
    ViewBindingFragment<FragmentMovieListBinding, MovieViewModel>() {
    override val viewModel by viewModels<MovieViewModel>()
    private var isViewRendered: Boolean = false
    private lateinit var movieListAdapter: MovieListAdapter
    private var onItemClicked = { id: String,title:String,image:String,years:String, view: View? ->
             findNavController().navigate(
                MovieListFragmentDirections.actionMovieToDetails(
                    id,
                    title,
                    image,
                    years
                )
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isViewRendered) {
            movieListAdapter =
                MovieListAdapter(onItemClicked)
            binding.rvMovie.layoutManager = LinearLayoutManager(binding.rvMovie.context)
            binding.rvMovie.adapter = movieListAdapter
            viewModel.getMovieList()
            observeSubscriptionFormResponse()
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentMovieListBinding =
        FragmentMovieListBinding.inflate(inflater, container, false)

    private fun observeSubscriptionFormResponse() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                when (it) {
                    is ViewState.Empty -> {
                    }
                    is ViewState.Failed -> {
                        Log.e("fail", it.message)
                        snackBarLayout(it.message)
                    }
                    is ViewState.Loading -> {
                    }
                    is ViewState.Success -> {
                        setAdapter(it.data)
                        isViewRendered = true
                    }
                }
            }
        }
    }

    private fun setAdapter(data: List<Search>) {
        movieListAdapter.setContent(data)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

}
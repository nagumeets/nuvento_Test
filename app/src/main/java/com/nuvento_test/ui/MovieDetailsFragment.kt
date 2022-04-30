package com.nuvento_test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nuvento_test.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    ViewBindingFragment<FragmentMovieDetailsBinding, MovieViewModel>() {
    private val args: MovieDetailsFragmentArgs by navArgs()
    private var isViewRendered: Boolean = false
    override val viewModel by viewModels<MovieViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isViewRendered) {
            binding.navToolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            binding.toolbarTitle.text = args.title
            Glide.with(binding.ivMovie)
                .load(args.image)
                .into(binding.ivMovie)
            binding.tvTitle.text = "Movie Title: ${args.title}"
            binding.tvYears.text = "Release Years: ${args.year}"
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentMovieDetailsBinding =
        FragmentMovieDetailsBinding.inflate(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}
package com.nuvento_test.repository.impl

import com.nuvento_test.data.model.Response
import com.nuvento_test.data.model.Search
import com.nuvento_test.data.remote.api.MovieFeedService
import com.nuvento_test.data.remote.utils.getResponse
import com.nuvento_test.repository.MovieRepository
import com.nuvento_test.util.NetworkConnectivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class MovieRepositoryImpl @Inject internal constructor(
    private val movieFeedService: MovieFeedService,
    private val networkConnectivity: NetworkConnectivity
) :
    MovieRepository {

    override fun getMovieFeed(): Flow<Response<List<Search>>> = flow {
        if (!networkConnectivity.isConnected()) {
            emit(Response.error("You are offline. Connect to the Internet to access the app"))
            return@flow
        } else {
            val movieFeedResponse = movieFeedService.getMovieFeed().getResponse()

            val state =
                if (movieFeedResponse.Search != null) Response.success(movieFeedResponse.Search) else Response.error(
                    "Something went wrong"
                )
            emit(state)
        }
    }.catch { e -> emit(Response.error("Something went wrong $e")) }

}
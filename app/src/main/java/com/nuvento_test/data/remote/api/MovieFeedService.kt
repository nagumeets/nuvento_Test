package com.nuvento_test.data.remote.api

import com.nuvento_test.data.model.MovieFeedResponse
import retrofit2.Response
import retrofit2.http.*

interface MovieFeedService {

    @GET("?apikey=eb997622&s=batman")
    suspend fun getMovieFeed(): Response<MovieFeedResponse>
}

package com.nuvento_test.repository

import com.nuvento_test.data.model.Response
import com.nuvento_test.data.model.Search
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface MovieRepository {
    fun getMovieFeed(): Flow<Response<List<Search>>>
}

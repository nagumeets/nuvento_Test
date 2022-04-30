package com.nuvento_test.di

import com.nuvento_test.data.remote.api.MovieFeedService
import com.nuvento_test.data.remote.interceptor.ApiKeyInterceptor
import com.nuvento_test.util.Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val baseRetrofitBuilder: Retrofit.Builder =
        Retrofit.Builder().baseUrl(Url.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        )
    private val okHttpBuilder: OkHttpClient.Builder =
        OkHttpClient.Builder().readTimeout(1, TimeUnit.MINUTES).writeTimeout(1, TimeUnit.MINUTES)

    @Provides
    fun provideMovieFeedService(
        apiKeyInterceptor: ApiKeyInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): MovieFeedService {
        return baseRetrofitBuilder.client(
            okHttpBuilder.addInterceptor(httpLoggingInterceptor).addInterceptor(apiKeyInterceptor)
                .build()
        ).build().create(MovieFeedService::class.java)
    }
    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}
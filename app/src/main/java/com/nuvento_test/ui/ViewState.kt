package com.nuvento_test.ui

sealed class ViewState<T> {
    class Loading<T> : ViewState<T>()
    class Success<T>(val data: T) : ViewState<T>()
    class Empty<T> : ViewState<T>()
    class Failed<T>(val message: String) : ViewState<T>()
    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> empty() = Empty<T>()
        fun <T> failed(message: String) = Failed<T>(message)
    }
}

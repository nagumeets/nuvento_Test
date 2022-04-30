package com.nuvento_test.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieFeedResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
):Parcelable

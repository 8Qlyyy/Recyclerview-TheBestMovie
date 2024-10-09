package com.zaqly.thebestmovie


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val name: String,
    val genre: String,
    val photo: Int,
    val sinopsis: String
) : Parcelable
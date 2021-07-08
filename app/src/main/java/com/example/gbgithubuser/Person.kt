package com.example.gbgithubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val username: String?,
    val img: Int?,
    val followers: Int?,
    val following: Int?,
    val location: String?,
    val name_repositori: String?,
    val language_repositori: String?,
    val company: String?
): Parcelable
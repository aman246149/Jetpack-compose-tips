package com.example.udemycompose.model

import android.os.Parcelable
import kotlinx.serialization.Serializable


@Serializable
data class User(
    val name: String,
    val age: String,
    val id: Int
)
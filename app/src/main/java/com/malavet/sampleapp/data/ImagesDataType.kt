package com.malavet.sampleapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The data type that is returned from the API.
 */

@Entity
data class ImagesDataType(
    @PrimaryKey
    val id: Int,
    val author: String,
    val download_url: String,
    val height: Int,
    val url: String,
    val width: Int
)
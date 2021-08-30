package com.malavet.sampleapp.http

import com.malavet.stockapp.http.ImageService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory;

object ImageRequest {

    val logger = HttpLoggingInterceptor().apply { level =
            HttpLoggingInterceptor.Level.BASIC
    }

    val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://picsum.photos/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    object ImageApi {
        val retrofitService : ImageService by lazy { retrofit.create(ImageService::class.java) }
    }
}
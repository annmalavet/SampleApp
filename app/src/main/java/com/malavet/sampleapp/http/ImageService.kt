package com.malavet.sampleapp.http

import com.malavet.sampleapp.data.ImagesDataType
import retrofit2.http.GET

interface ImageService {

    @GET("v2/list")
    suspend fun getApiResponse() : List<ImagesDataType>

}
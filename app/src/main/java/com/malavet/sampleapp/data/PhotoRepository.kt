package com.malavet.sampleapp.data

import androidx.lifecycle.LiveData
import com.malavet.sampleapp.http.ImageRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PhotoRepository ( val database: PhotoDatabase) {
    val data: LiveData<List<ImagesDataType>> =
        database.photoDao().getAll()

     fun dataTen(): List<ImagesDataType>{
        return database.photoDao().getTen()
    }

    suspend fun requestData() {
        withContext(Dispatchers.IO) {

            if(database.photoDao().getCount() == 0) {
                val response = ImageRequest.ImageApi.retrofitService.getApiResponse()
                database.photoDao().insertAll(response)
            }

        }
    }

     fun returnAll(): LiveData<List<ImagesDataType>> {
        return data
    }

   // fun returnSome(): List<ImagesDataType> {
     //   return dataTen
    //}

}




package com.malavet.sampleapp.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.malavet.sampleapp.data.PhotoRepository
import com.malavet.sampleapp.data.getDB
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application)
 {
     val repository = PhotoRepository(getDB(application))

     init {
         getData()
     }

     fun CoroutineScope.launchCatchSafe(launchBody: suspend () -> Unit): Job {
         val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ ->
             Log.i("Exception", "Coroutine Exception")
         }

         return this.launch(coroutineExceptionHandler) {
             launchBody.invoke()
         }
     }

     /*
     Calling request from repository
     */
     internal fun getData() {
         viewModelScope.launchCatchSafe() {
             viewModelScope.launchCatchSafe() {
                 try {
                     repository.requestData()
                 } catch (e: Exception) {
                     if (repository.data.value.isNullOrEmpty()) {
                     }
                 }
             }
         }
     }
}



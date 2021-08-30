package com.malavet.sampleapp.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith
import java.util.concurrent.Executors

@RunWith(AndroidJUnit4::class)
class PhotoDatabaseTest : TestCase() {
    private lateinit var db: PhotoDatabase
    private lateinit var dao: PhotoDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, PhotoDatabase::class.java)
            .setTransactionExecutor(Executors.newSingleThreadExecutor())
            .build()
        dao = db.photoDao()
    }


    @Test
    @Throws(Exception::class)
    fun writeAndReadImagesDataType():Unit = runBlocking {
        val testData = ImagesDataType(2, "Ann Malavet", "url", 100, "url_img", 100)
        var data:ImagesDataType
        dao.run {
            insertOne(testData)
            data= getById(3)
        }

        Assert.assertEquals(data, testData)

    }

    @After
    fun closeDb() {
        db.close()
    }


}

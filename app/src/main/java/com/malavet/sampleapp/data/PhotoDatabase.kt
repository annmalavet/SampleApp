package com.malavet.sampleapp.data

import android.content.Context
import androidx.room.*


/**
 *Room database to store api response
 */

@Database(entities = [ImagesDataType::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
        private lateinit var db: PhotoDatabase

        fun getDB(context: Context): PhotoDatabase {
            synchronized(PhotoDatabase::class.java) {
                if (!::db.isInitialized) {
                    db = Room.databaseBuilder(
                        context.applicationContext,
                        PhotoDatabase::class.java,
                        "images"
                    ).build()
                }
                return db
            }
        }




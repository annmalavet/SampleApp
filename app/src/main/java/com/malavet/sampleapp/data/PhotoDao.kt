package com.malavet.sampleapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * The com.malavet.sampleapp.data.Data Access Object for the [] class.
 */
@Dao
interface PhotoDao {

    @Query("SELECT count(id) FROM Imagesdatatype")
    fun getCount(): Int

    @Query("SELECT * FROM Imagesdatatype")
    fun getAll(): LiveData<List<ImagesDataType>>

    @Query("SELECT * FROM Imagesdatatype LIMIT 10")
    fun getTen(): List<ImagesDataType>

    @Query(value = "SELECT * FROM Imagesdatatype where id == :author_id")
    fun getById(author_id: Int? = null): ImagesDataType

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(photoData: ImagesDataType)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photoData: List<ImagesDataType>)

}

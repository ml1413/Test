package com.hutapp.org.notes.hut.test.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Insert
    suspend fun addPerson(personEntity: PersonEntity)

    @Delete
    suspend fun deletePerson(personEntity: PersonEntity)

    @Query("select*from  test_table ORDER BY id DESC")
    fun getAllModel(): LiveData<List<PersonEntity>>
}
package com.hutapp.org.notes.hut.test.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDataBase : RoomDatabase() {
    abstract fun getDao(): PersonDao
}
package com.hutapp.org.notes.hut.test.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "test_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val lastName: String
)
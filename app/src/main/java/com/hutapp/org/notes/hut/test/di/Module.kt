package com.hutapp.org.notes.hut.test.di

import android.content.Context
import androidx.room.PrimaryKey
import androidx.room.Room
import com.hutapp.org.notes.hut.test.db.PersonDataBase
import com.hutapp.org.notes.hut.test.db.PersonRepositoryDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun getDB(@ApplicationContext context: Context): PersonDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = PersonDataBase::class.java,
            name = "person_db"
        ).build()
    }

    @Provides
    @Singleton
    fun getRepositoryPersonDB(personDataBase: PersonDataBase): PersonRepositoryDB {
        return PersonRepositoryDB(dataBase = personDataBase)
    }
}
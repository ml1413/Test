package com.hutapp.org.notes.hut.test.db

import javax.inject.Inject

class PersonRepositoryDB @Inject constructor(private val dataBase: PersonDataBase) {
    private val personDao = dataBase.getDao()
    fun getAll() = personDao.getAllModel()
    suspend fun addPerson(personEntity: PersonEntity) {
        personDao.addPerson(personEntity = personEntity)
    }

    suspend fun deletePerson(personEntity: PersonEntity) {
        personDao.deletePerson(personEntity = personEntity)
    }
}
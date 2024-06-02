package com.hutapp.org.notes.hut.test.db

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val repositoryDB: PersonRepositoryDB) :
    ViewModel() {
    private val _persons = MutableLiveData<List<PersonEntity>>()
    val persons: LiveData<List<PersonEntity>> = _persons

    //observer______________________________________________________________________________________
    private val observer =
        Observer<List<PersonEntity>> { listPerson -> _persons.postValue(listPerson) }

    init {
        repositoryDB.getAll().observeForever(observer)
    }

    override fun onCleared() {
        repositoryDB.getAll().removeObserver(observer)
        super.onCleared()
    }

    //______________________________________________________________________________________________
    fun addPerson(personEntity: PersonEntity) {
        viewModelScope.launch {
            Log.d("TAG1", "addPerson: ")
            repositoryDB.addPerson(personEntity = personEntity)
        }
    }

    fun deletePerson(personEntity: PersonEntity) {
        viewModelScope.launch {
            repositoryDB.deletePerson(personEntity = personEntity)
        }
    }
}

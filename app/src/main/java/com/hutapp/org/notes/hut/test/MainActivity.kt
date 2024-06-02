package com.hutapp.org.notes.hut.test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hutapp.org.notes.hut.test.databinding.ActivityMainBinding
import com.hutapp.org.notes.hut.test.db.PersonEntity
import com.hutapp.org.notes.hut.test.db.PersonViewModel
import com.hutapp.org.notes.hut.test.db.Recycler.AdapterPerson
import com.hutapp.org.notes.hut.test.screenFronFigma.ScreenFromFigmaFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<PersonViewModel>()
    private var personForDelete: PersonEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        onAddButtonClickListener()
        onDeleteClickListener()
        openScreenFragment()

    }

    private fun openScreenFragment() {
        binding.openScreen.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, ScreenFromFigmaFragment())
                .addToBackStack("")
                .commit()
        }
    }


    private fun onDeleteClickListener() {
        binding.btDelete.setOnClickListener {
            personForDelete?.let { personEntity ->
                viewModel.deletePerson(personEntity = personEntity)
                binding.btDelete.isEnabled = false
                binding.tvDel.text = ""
            }
        }
    }

    private fun observeViewModel() {
        viewModel.persons.observe(this) { listPerson ->
            binding.maiRecycler.adapter = AdapterPerson(
                listPerson = listPerson,
                onItemClick = { personEntity ->
                    personForDelete = personEntity
                    binding.tvDel.text = "delete ${personEntity.name} ?"
                    binding.btDelete.isEnabled = true
                })
        }
    }

    private fun onAddButtonClickListener() {
        binding.btAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val lastName = binding.etLastName.text.toString()
            if (name.isNotBlank() && lastName.isNotBlank()) {
                val person = PersonEntity(name = name, lastName = lastName)
                viewModel.addPerson(personEntity = person)
            } else {
                Toast.makeText(this, "Empty field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
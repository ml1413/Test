package com.hutapp.org.notes.hut.test.db.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hutapp.org.notes.hut.test.R
import com.hutapp.org.notes.hut.test.databinding.ItemForPersonEntityBinding
import com.hutapp.org.notes.hut.test.db.PersonEntity

class AdapterPerson(
    private val listPerson: List<PersonEntity>,
    private val onItemClick: (PersonEntity) -> Unit = {}
) : RecyclerView.Adapter<PersonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_for_person_entity,
                parent, false
            )
        return PersonHolder(view, onItemClick = onItemClick)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.initView(personEntity = listPerson[position])
    }

    override fun getItemCount() = listPerson.size
}

class PersonHolder(view: View, private val onItemClick: (personEntity: PersonEntity) -> Unit) :
    ViewHolder(view) {
    private val binding = ItemForPersonEntityBinding.bind(view)
    fun initView(personEntity: PersonEntity) {
        binding.name.text = personEntity.name
        binding.lastName.text = personEntity.lastName
        itemView.setOnClickListener {
            onItemClick(personEntity)
        }
    }
}
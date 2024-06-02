package com.hutapp.org.notes.hut.test.screenFronFigma.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hutapp.org.notes.hut.test.R
import com.hutapp.org.notes.hut.test.databinding.ItemBinding
import com.hutapp.org.notes.hut.test.screenFronFigma.model.ModelIdem

class MyRecyclerAdapter(
    private val listForDashboard: List<ModelIdem>,
    private val clickOnIteM: (ModelIdem) -> Unit = {}
) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item,
                parent,
                false
            )
        return MyHolder(view = view, clickOnIteM = clickOnIteM)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.initView(listForDashboard[position])
    }

    override fun getItemCount() = listForDashboard.size
}

class MyHolder(view: View, private val clickOnIteM: (ModelIdem) -> Unit) : ViewHolder(view) {
    private val binding = ItemBinding.bind(view)
    fun initView(modelIdem: ModelIdem) {
        binding.image.setImageResource(modelIdem.image)
        binding.label.text = modelIdem.label
        binding.text.text = modelIdem.text
        if (modelIdem.countMessage > 0) {
            binding.imageForeground.setPadding(12, 0, 0, 0)
            binding.countMassage.visibility = View.VISIBLE
            binding.countMassage.text = modelIdem.countMessage.toString()
        }
        itemView.setOnClickListener { clickOnIteM(modelIdem) }
    }
}
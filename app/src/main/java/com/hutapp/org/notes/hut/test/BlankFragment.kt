package com.hutapp.org.notes.hut.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hutapp.org.notes.hut.test.databinding.FragmentBlankBinding
import com.hutapp.org.notes.hut.test.model.ListForItem
import com.hutapp.org.notes.hut.test.recyclerView.MyRecyclerAdapter

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private lateinit var myRecyclerAdapter: MyRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val list = ListForItem.getList()
        myRecyclerAdapter = MyRecyclerAdapter(listForDashboard = list) {
            Toast.makeText(requireContext(), it.label, Toast.LENGTH_SHORT).show()
        }
        binding.includeSheet.recycler.adapter = myRecyclerAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nitIncludeCardScan()
        nitIncludeCardCheck()
    }

    private fun nitIncludeCardScan() {
        binding.cardDriveScan.apply {
            im.setImageResource(R.drawable.hdd)
            label.text = getString(R.string.devise_scan)
            text.text = getString(R.string.show)
            button.text = getString(R.string.text_button_scan)
        }
    }

    private fun nitIncludeCardCheck() {
        binding.cardCheckVirus.apply {
            im.setImageResource(R.drawable.virus)
            label.text = getString(R.string.check_viruses)
            text.text = getString(R.string.show_you_all_info)
            button.text = getString(R.string.check)
        }
    }

}
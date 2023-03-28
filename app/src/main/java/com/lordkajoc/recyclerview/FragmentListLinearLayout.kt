package com.lordkajoc.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.FragmentListLinearLayoutBinding

class FragmentListLinearLayout : Fragment() {
    private val list = ArrayList<KumpulanAbjad>()
    private lateinit var binding: FragmentListLinearLayoutBinding
    private lateinit var recyclerviewabjadGrid : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListLinearLayoutBinding.inflate(layoutInflater,container,false)
        recyclerviewabjadGrid = binding.recyclerviewlinear
        recyclerviewabjadGrid.setHasFixedSize(true)
        list.addAll(getlistabjad())
        showRecyclerListLinear()
        return binding.root
    }

    private fun getlistabjad(): ArrayList<KumpulanAbjad>{
        val dataNama = resources.getStringArray(R.array.data_abjad)
        val listAbjad = ArrayList<KumpulanAbjad>()
        for(i in dataNama.indices) {
            val abjad = KumpulanAbjad(dataNama[i])
            listAbjad.add(abjad)
        }
        return listAbjad
    }
    private fun showRecyclerListLinear() {
        recyclerviewabjadGrid.layoutManager = LinearLayoutManager(context)
        val listAbjadAdapter = ListAdapterAbjad(list)
        recyclerviewabjadGrid.adapter = listAbjadAdapter
    }
}
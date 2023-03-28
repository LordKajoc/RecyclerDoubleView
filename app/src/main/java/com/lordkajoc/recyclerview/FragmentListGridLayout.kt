package com.lordkajoc.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.FragmentListGridLayoutBinding

class FragmentListGridLayout : Fragment() {
    private lateinit var binding: FragmentListGridLayoutBinding
    private val list = ArrayList<KumpulanAbjad>()
    private lateinit var recyclerviewabjadGrid : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListGridLayoutBinding.inflate(layoutInflater,container,false)
        recyclerviewabjadGrid = binding.recyclerviewgrid
        recyclerviewabjadGrid.setHasFixedSize(true)
        list.addAll(getlistabjad())
        showRecyclerListGrid()
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

    private fun showRecyclerListGrid() {
        val viewGridLayout = GridLayoutManager(context,2)
        recyclerviewabjadGrid.layoutManager = viewGridLayout
        val listAbjadAdapter = ListAdapterAbjad(list)
        recyclerviewabjadGrid.adapter = listAbjadAdapter
        list.addAll(getlistabjad())
    }
}
package com.lordkajoc.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.FragmentListGridLayoutBinding

class FragmentListGridLayout : Fragment() {
    val list = ArrayList<KumpulanAbjad>()
    lateinit var binding: FragmentListGridLayoutBinding
    lateinit var recyclerviewabjadGrid: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListGridLayoutBinding.inflate(layoutInflater, container, false)
        recyclerviewabjadGrid = binding.recyclerviewgrid
        recyclerviewabjadGrid.setHasFixedSize(true)
        showRecyclerListGrid()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.tbGrid.ivIclist
        val fragmentlinear = FragmentListLinearLayout()
        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentlinear)
        }
    }

    private fun getlistabjad(): ArrayList<KumpulanAbjad> {
        val dataNama = resources.getStringArray(R.array.data_abjad)
        val listAbjad = ArrayList<KumpulanAbjad>()
        for (i in dataNama.indices) {
            val abjad = KumpulanAbjad(dataNama[i])
            listAbjad.add(abjad)
        }
        return listAbjad
    }

    private fun showRecyclerListGrid() {
        val viewGridLayout = GridLayoutManager(context, 2)
        recyclerviewabjadGrid.layoutManager = viewGridLayout
        val listAbjadAdapter = ListAdapterAbjad(list)
        recyclerviewabjadGrid.adapter = listAbjadAdapter
        list.clear()
        list.addAll(getlistabjad())
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }


}
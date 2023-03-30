package com.lordkajoc.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.FragmentListLinearLayoutBinding

class FragmentListLinearLayout : Fragment() {
    val list = ArrayList<KumpulanAbjad>()
    lateinit var binding: FragmentListLinearLayoutBinding
    lateinit var recyclerabjadLinear: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListLinearLayoutBinding.inflate(layoutInflater, container, false)
        recyclerabjadLinear = binding.recyclerviewlinear
        recyclerabjadLinear.setHasFixedSize(true)
        showRecyclerListLinear()
        binding.recyclerviewlinear.setOnClickListener {

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.tbLinear.ivIcgrid
        val fragmentgrid = FragmentListGridLayout()
        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentgrid)
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

    private fun showRecyclerListLinear() {
        recyclerabjadLinear.layoutManager = LinearLayoutManager(context)
        val listAbjadAdapter = ListAdapterAbjad(list)
        recyclerabjadLinear.adapter = listAbjadAdapter
        list.clear()
        list.addAll(getlistabjad())
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }


}
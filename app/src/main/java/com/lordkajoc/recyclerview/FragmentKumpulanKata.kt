package com.lordkajoc.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.FragmentKumpulanKataBinding

class FragmentKumpulanKata : Fragment() {
    val listkata = ArrayList<KumpulanKata>()
    lateinit var binding: FragmentKumpulanKataBinding
    lateinit var recyclerviewKata: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKumpulanKataBinding.inflate(layoutInflater, container, false)
        val args = this.arguments
        val dikirimdata = args?.get("ABJAD")
        binding.tbStartword.textView.text = "Word That Start With $dikirimdata"
        recyclerviewKata = binding.recyclerviewword
        recyclerviewKata.setHasFixedSize(true)
        showRecyclerListWordLinear()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageback = binding.tbStartword.ivIcback
        val fragmentback = FragmentListLinearLayout()
        imageback.setOnClickListener {
            setCurrentFragment(fragmentback)
        }
    }

    private fun getlistKata(): ArrayList<KumpulanKata> {
        val args = this.arguments
        val dikirimdata = args?.get("ABJAD")
        val dataKata = resources.getStringArray(R.array.Huruf)

        val listKata = ArrayList<KumpulanKata>()
        Toast.makeText(context, "Data Sesuai", Toast.LENGTH_SHORT).show()
            for (i in dataKata.indices) {
                val firstletter = dataKata[i].take(1)
                if (firstletter == dikirimdata) {
                    val kata = KumpulanKata(dataKata[i])
                    listKata.add(kata)
                }
            }

        return listKata
    }

    private fun showRecyclerListWordLinear() {
        recyclerviewKata.layoutManager = LinearLayoutManager(context)
        val listHurufAdapter = ListAdapterHuruf(listkata)
        recyclerviewKata.adapter = listHurufAdapter
        listkata.clear()
        listkata.addAll(getlistKata())
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}
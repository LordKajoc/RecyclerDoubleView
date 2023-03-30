package com.lordkajoc.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerview.databinding.CardviewListItemBinding

class ListAdapterHuruf(private val listHuruf: ArrayList<KumpulanKata>) :
    RecyclerView.Adapter<ListAdapterHuruf.ViewHolder>() {
    //Class ViewHolder
    class ViewHolder(var binding: CardviewListItemBinding) : RecyclerView.ViewHolder(binding.root)

    //Membuat holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    //Melakukan penentuan data yang akan ditampilkan pada setiap item/baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvAbjad.text = listHuruf[position].katakata
        /*holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                val gridFragment = FragmentListGridLayout()
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_container, gridFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })*/
    }

    override fun getItemCount(): Int {
        return listHuruf.size
    }
}
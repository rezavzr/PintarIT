package com.aplikasi.pintarit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PythonAdapter(private val myListOfGambar: List<DataFotoPython>,
private val clickListenerPython:(DataFotoPython) -> Unit): RecyclerView.Adapter<MyFotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFotoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_python, parent, false)
        return MyFotoHolder(listItem)

    }


    override fun onBindViewHolder(holder: MyFotoHolder, position: Int) {
        val i = myListOfGambar[position]
        holder.bindIt(i, clickListenerPython)
    }

    override fun getItemCount(): Int {
        return myListOfGambar.size
    }
}

class MyFotoHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindIt(item: DataFotoPython, clickListenerPython:(DataFotoPython) -> Unit) {
        val ivItemImg = view.findViewById<ImageView>(R.id.ivGambarPython)
        val cardView = view.findViewById<CardView>(R.id.cvPython)
        ivItemImg.setImageResource(item.img)
        cardView.setOnClickListener {
            clickListenerPython(item)
        }
    }
}
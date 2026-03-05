package com.aplikasi.pintarit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BahasaAdapter(private val myListOfBahasa: List<DataBahasaProgram>,
                    private val clickListenerBahasa:(DataBahasaProgram) -> Unit): RecyclerView.Adapter<MyBahasaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBahasaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_bahasa_program, parent, false)
        return MyBahasaHolder(listItem)

    }


    override fun onBindViewHolder(holder: MyBahasaHolder, position: Int) {
        val item = myListOfBahasa[position]
        holder.bindIt(item, clickListenerBahasa)
    }

    override fun getItemCount(): Int {
        return myListOfBahasa.size
    }
}

class MyBahasaHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindIt(item: DataBahasaProgram, clickListenerBahasa:(DataBahasaProgram) -> Unit) {
        val tvTitle = view.findViewById<TextView>(R.id.tvJudulMateriBahasa)
        val ivItemImg = view.findViewById<ImageView>(R.id.ivGambarBahasa)
        val cardView = view.findViewById<CardView>(R.id.cvBahasa)
        tvTitle.text = item.title
        ivItemImg.setImageResource(item.img)
        cardView.setOnClickListener {
            clickListenerBahasa(item)
        }
    }
}
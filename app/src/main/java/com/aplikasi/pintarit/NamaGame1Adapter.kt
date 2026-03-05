package com.aplikasi.pintarit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NamaGame1Adapter(private val myListOfNamaGame1: List<DataNamaGame1>,
                       private val clickListenerNamaGame1:(DataNamaGame1) -> Unit): RecyclerView.Adapter<MyNamaGame1Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNamaGame1Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_game, parent, false)
        return MyNamaGame1Holder(listItem)

    }


    override fun onBindViewHolder(holder: MyNamaGame1Holder, position: Int) {
        val item = myListOfNamaGame1[position]
        holder.bindIt(item, clickListenerNamaGame1)
    }

    override fun getItemCount(): Int {
        return myListOfNamaGame1.size
    }
}

class MyNamaGame1Holder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindIt(item: DataNamaGame1, clickListenerNamaGame1:(DataNamaGame1) -> Unit) {
        val tvTitle = view.findViewById<TextView>(R.id.tvJudulMateriGame1)
        val ivItemImg = view.findViewById<ImageView>(R.id.ivGamePilih1)
        val cardView = view.findViewById<CardView>(R.id.cvNamaGame1)
        tvTitle.text = item.title
        ivItemImg.setImageResource(item.img)
        cardView.setOnClickListener {
            clickListenerNamaGame1(item)
        }
    }
}
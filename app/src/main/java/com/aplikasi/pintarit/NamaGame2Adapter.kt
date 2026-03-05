package com.aplikasi.pintarit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NamaGame2Adapter(private val myListOfNamaGame2: List<DataNamaGame2>,
                       private val clickListenerNamaGame2:(DataNamaGame2) -> Unit): RecyclerView.Adapter<MyNamaGame2Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNamaGame2Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_game2, parent, false)
        return MyNamaGame2Holder(listItem)

    }


    override fun onBindViewHolder(holder: MyNamaGame2Holder, position: Int) {
        val item = myListOfNamaGame2[position]
        holder.bindIt(item, clickListenerNamaGame2)
    }

    override fun getItemCount(): Int {
        return myListOfNamaGame2.size
    }
}

class MyNamaGame2Holder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindIt(item: DataNamaGame2, clickListenerNamaGame2:(DataNamaGame2) -> Unit) {
        val tvTitle = view.findViewById<TextView>(R.id.tvJudulMateriGame2)
        val ivItemImg = view.findViewById<ImageView>(R.id.ivGamePilih2)
        val cardView = view.findViewById<CardView>(R.id.cvNamaGame2)
        tvTitle.text = item.title
        ivItemImg.setImageResource(item.img)
        cardView.setOnClickListener {
            clickListenerNamaGame2(item)
        }
    }
}
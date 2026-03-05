package com.aplikasi.pintarit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class JaringanAdapter(private val myListOfJaringan: List<DataMateriJaringan>,
                      private val clickListenerJaringan:(DataMateriJaringan) -> Unit): RecyclerView.Adapter<MyJaringanHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyJaringanHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_jaringan, parent, false)
        return MyJaringanHolder(listItem)

    }


    override fun onBindViewHolder(holder: MyJaringanHolder, position: Int) {
        val item = myListOfJaringan[position]
        holder.bindIt(item, clickListenerJaringan)
    }

    override fun getItemCount(): Int {
        return myListOfJaringan.size
    }
}

class MyJaringanHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindIt(item: DataMateriJaringan, clickListenerJaringan:(DataMateriJaringan) -> Unit) {
        val tvTitle = view.findViewById<TextView>(R.id.tvJudulMateriJaringan)
        val ivItemImg = view.findViewById<ImageView>(R.id.ivGambarJaringan)
        val cardView = view.findViewById<CardView>(R.id.cvJaringan)
        tvTitle.text = item.title
        ivItemImg.setImageResource(item.img)
        cardView.setOnClickListener {
            clickListenerJaringan(item)
        }
    }
}
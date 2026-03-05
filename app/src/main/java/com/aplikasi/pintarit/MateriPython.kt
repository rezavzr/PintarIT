package com.aplikasi.pintarit

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MateriPython : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_python)
        val myListOfGambar = listOf<DataFotoPython>(
            DataFotoPython(R.drawable.python1),
            DataFotoPython(R.drawable.python2),
            DataFotoPython(R.drawable.python3),
            DataFotoPython(R.drawable.python4),
        )

        val recyclerPython = findViewById<RecyclerView>(R.id.rvPython)
        recyclerPython.setBackgroundColor(Color.TRANSPARENT)
        recyclerPython.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerPython.adapter = PythonAdapter(
            myListOfGambar,){
                selectedItem: DataFotoPython ->listItemClickedPython(selectedItem)
        }


    }

    fun listItemClickedPython(list: DataFotoPython) {
        when (list.img) {
            R.drawable.test-> {
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
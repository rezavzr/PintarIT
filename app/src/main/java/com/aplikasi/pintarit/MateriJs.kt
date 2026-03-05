package com.aplikasi.pintarit

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MateriJs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_js)

        val myListOfGambar = listOf<DataFotoPython>(
            DataFotoPython(R.drawable.js1),
            DataFotoPython(R.drawable.js2),
            DataFotoPython(R.drawable.js3),
            DataFotoPython(R.drawable.js4),
        )

        val recyclerPython = findViewById<RecyclerView>(R.id.rvJS)
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
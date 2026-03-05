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

class MateriCPP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_cpp)

        val myListOfGambar = listOf<DataFotoPython>(
            DataFotoPython(R.drawable.test),
            DataFotoPython(R.drawable.test2),
            DataFotoPython(R.drawable.test3),
            DataFotoPython(R.drawable.test4),
            DataFotoPython(R.drawable.test5),
        )

        val recyclerPython = findViewById<RecyclerView>(R.id.rvCpp)
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
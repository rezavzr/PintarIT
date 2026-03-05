package com.aplikasi.pintarit

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.pintarit.databinding.FragmentPlayBinding

class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    val listOfNamaGame1 = listOf<DataNamaGame1>(
        DataNamaGame1("Multiple Choice Quizz", R.drawable.multiple_choice_icon),
        DataNamaGame1("Memory Game", R.drawable.memory_icon)
    )
//    val listOfNamaGame2 = listOf<DataNamaGame2>(
//        DataNamaGame2("Matching Game", R.drawable.logo_python),
//        DataNamaGame2("P", R.drawable.play_2)
//    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        val recyclerNamaGame1 = binding.root.findViewById<RecyclerView>(R.id.rvNamaGame1)
        recyclerNamaGame1.setBackgroundColor(Color.TRANSPARENT)
        recyclerNamaGame1.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerNamaGame1.adapter = NamaGame1Adapter(
            listOfNamaGame1,){
                selectedItem: DataNamaGame1->listItemClickedNamagame1(selectedItem)
        }

//        val recyclerNamaGame2 = binding.root.findViewById<RecyclerView>(R.id.rvNamaGame2)
//        recyclerNamaGame2.setBackgroundColor(Color.TRANSPARENT)
//        recyclerNamaGame2.layoutManager =
//            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        recyclerNamaGame2.adapter = NamaGame2Adapter(
//            listOfNamaGame2,){
//                selectedItem: DataNamaGame2->listItemClickedNamagame2(selectedItem)
//        }
        return binding.root
    }

    private fun listItemClickedNamagame1(list: DataNamaGame1) {
        if(list.title == "Multiple Choice Quizz") {
            val intent = Intent(activity, PilihanGandaBahasaProgram::class.java)
            startActivity(intent)
        } else if (list.title == "Memory Game") {
            val intent = Intent(activity, GameMatching::class.java)
            startActivity(intent)
        }
    }

//    private fun listItemClickedNamagame2(list: DataNamaGame2) {
//        when (list.title) {
//            "Matching Game" -> {
//                val intent = Intent(activity, GameMatching::class.java)
//                startActivity(intent)
//            }
//            else -> {
//                Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
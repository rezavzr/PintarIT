package com.aplikasi.pintarit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.pintarit.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var sf: SharedPreferences
    private lateinit var binding: FragmentHomeBinding
    val listOfMateriJaringan = listOf<DataMateriJaringan>(
        DataMateriJaringan("Wan?", R.drawable.wan),
        DataMateriJaringan("Topologi Jaringan", R.drawable.topologi),
    )
    val listOfMateriBahasa = listOf<DataBahasaProgram>(
        DataBahasaProgram("Python", R.drawable.logo_python),
        DataBahasaProgram("C++", R.drawable.logo_cpp),
        DataBahasaProgram("Kotlin", R.drawable.logo_kotlin),
        DataBahasaProgram("Javascript", R.drawable.logo_js),
        DataBahasaProgram("Java", R.drawable.logo_java)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        sf = requireActivity().applicationContext.getSharedPreferences("saved_preferences", Context.MODE_PRIVATE)
        val username = sf.getString("sf_username", null)

        val tvHello = binding.root.findViewById<TextView>(R.id.tvHelloUser)
        tvHello.text = "Hello, ${username}"

        val recyclerJrngn = binding.root.findViewById<RecyclerView>(R.id.rvJaringanKomputer)
        recyclerJrngn.setBackgroundColor(Color.TRANSPARENT)
        recyclerJrngn.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerJrngn.adapter = JaringanAdapter(
            listOfMateriJaringan,){
            selectedItem: DataMateriJaringan ->listItemClickedJaringan(selectedItem)
        }

        val recyclerBahasa = binding.root.findViewById<RecyclerView>(R.id.rvBahasaProgram)
        recyclerBahasa.setBackgroundColor(Color.TRANSPARENT)
        recyclerBahasa.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerBahasa.adapter = BahasaAdapter(
            listOfMateriBahasa,){
                selectedItem: DataBahasaProgram ->listItemClickedBahasa(selectedItem)
        }
        
        return binding.root
}
    private fun listItemClickedJaringan(list: DataMateriJaringan) {
        when (list.title) {
            "Wan?" -> {
                Toast.makeText(activity, "Coming Soon :)", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(activity, "Coming Soon :)", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun listItemClickedBahasa(list: DataBahasaProgram) {
        when (list.title) {
            "Python" -> {
                val intent = Intent(activity, MateriPython::class.java)
                startActivity(intent)
            }
            "C++" -> {
                val intent = Intent(activity, MateriCPP::class.java)
                startActivity(intent)
            }
            "Kotlin" -> {
                val intent = Intent(activity, MateriKotlin::class.java)
                startActivity(intent)
            }
            "Javascript" -> {
                val intent = Intent(activity, MateriJs::class.java)
                startActivity(intent)
            }
            "Java" -> {
                val intent = Intent(activity, MateriJava::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

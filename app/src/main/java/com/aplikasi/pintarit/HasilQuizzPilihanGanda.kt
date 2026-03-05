package com.aplikasi.pintarit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilQuizzPilihanGanda : AppCompatActivity() {
    private lateinit var sf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_quizz_pilihan_ganda)
        sf = getSharedPreferences("saved_preferences", MODE_PRIVATE)


        val tv_name = findViewById<TextView>(R.id.tv_name_hasil)
        val tv_score = findViewById<TextView>(R.id.tv_score_hasil)
        val btn_selesai = findViewById<Button>(R.id.bnt_selesai)

        val username = sf.getString("sf_username", null)
        tv_name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        tv_score.text = "Nilai kamu adalah $correctAnswer dari $totalQuestions"

        btn_selesai.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
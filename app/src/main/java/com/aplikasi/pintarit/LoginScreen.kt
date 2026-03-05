package com.aplikasi.pintarit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen : AppCompatActivity() {
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val btn_enter = findViewById<Button>(R.id.btn_enter)
        val et_name = findViewById<EditText>(R.id.et_name)
        sf = getSharedPreferences("saved_preferences", MODE_PRIVATE)
        editor = sf.edit()

        btn_enter.setOnClickListener{
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Tolong masukkan username terlebih dahulu", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                val username = et_name.text.toString()
                editor.apply {
                putString("sf_username", username)
                    commit()
                }
                startActivity(intent)
                finish()
            }
        }
    }
}
package com.aplikasi.pintarit

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aplikasi.pintarit.R.drawable.*
import com.aplikasi.pintarit.R.layout.activity_game_matching

class GameMatching : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_game_matching)

        val images: MutableList<Int> = mutableListOf(logo_c, logo_js, logo_java, logo_csharp, logo_python, logo_kotlin,
            logo_c, logo_js, logo_java, logo_csharp, logo_python, logo_kotlin)

        val buttons = Array<Button>(12) { findViewById<Button>(resources.getIdentifier("btn${it + 1}", "id", packageName)) }

        val cardBack: Int = logo_pintarit
        var clicked = 0
        var turnedOver = false
        var lastClicked = -1

        images.shuffle()
        for (i in 0..11) {
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnedOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked += 1
                } else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked -= 1
                }

                if (clicked == 2) {
                    turnedOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnedOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    turnedOver = false
                }
            }
        }

    }
}

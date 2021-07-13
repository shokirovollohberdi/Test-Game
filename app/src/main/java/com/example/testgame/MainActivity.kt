package com.example.testgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var num1 = 0
    var num2 = 0
    var amal = 4
    var answer = 0
    var random1 = 0
    var random2 = 0
    var random3 = 0
    var mode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random()

        next_btn.setOnClickListener {
            if (rad_a.isChecked) {
                if (rad_a.text.toString().toInt() == answer) Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                radioGroup.clearCheck()
            } else if (rad_b.isChecked) {
                if (rad_b.text.toString().toInt() == answer) Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                radioGroup.clearCheck()
            } else if (rad_c.isChecked) {
                if (rad_c.text.toString().toInt() == answer) Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                radioGroup.clearCheck()
            } else if (rad_d.isChecked) {
                if (rad_d.text.toString().toInt() == answer) Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                radioGroup.clearCheck()
            }
            random()
        }
        change_mode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (mode % 2 != 0) {
                mode++
                root.setBackgroundColor(Color.BLACK)
                change_mode.text = "Day Mode"
            } else if (mode % 2 == 0) {
                mode++
                root.setBackgroundColor(Color.WHITE)
                change_mode.text = "Night Mode"
            }
        }
    }

    fun random() {
        num1 = Random().nextInt(20)
        num2 = Random().nextInt(20)
        amal = Random().nextInt(4)
        write_quize()
    }

    fun write_quize() {
        when (amal) {
            0 -> {
                answer = num1 + num2
                quize.text = "$num1 + $num2"
            }
            1 -> {
                answer = num1 - num2
                quize.text = "$num1 - $num2"
            }
            2 -> {
                answer = num1 * num2
                quize.text = "$num1 * $num2"
            }
            3 -> {
                try {
                    if (num1 % num2 != 0) throw Exception()
                    answer = num1 / num2
                    quize.text = "$num1 / $num2"
                } catch (e: Exception) {
                    random()
                }

            }
        }
        write_answer()
    }

    fun randomNumber() {
        random1 = Random().nextInt(20)
        random2 = Random().nextInt(20)
        random3 = Random().nextInt(20)
        if (random1 == random2 || random2 == random3 || random3 == random1) {
            randomNumber()
        }
    }

    fun write_answer() {
        var rt = Random().nextInt(4)
        randomNumber()
        when (rt) {
            0 -> {
                rad_a.text = answer.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            1 -> {
                rad_a.text = random1.toString()
                rad_b.text = answer.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            2 -> {
                rad_a.text = random2.toString()
                rad_b.text = random1.toString()
                rad_c.text = answer.toString()
                rad_d.text = random3.toString()
            }
            3 -> {
                rad_a.text = random3.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = answer.toString()
            }
        }
    }
}
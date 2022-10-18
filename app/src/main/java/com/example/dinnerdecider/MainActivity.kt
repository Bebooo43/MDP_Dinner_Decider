package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodTV.text = foodList.first()

        decideBtn.setOnClickListener {
            val index = Random.nextInt(foodList.size)
            foodTV.text = foodList[index]
        }

        addFoodBtn.setOnClickListener {
            addFoodET.text?.toString()?.takeIf {
                it.isNotEmpty()
            }?.takeUnless {
                foodList.contains(it)
            }?.also {
                foodList.add(it)
                Toast.makeText(this, "Added: $it", Toast.LENGTH_LONG).show()
            }
        }
    }
}
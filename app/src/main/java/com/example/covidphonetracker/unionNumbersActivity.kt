package com.example.covidphonetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView


class unionNumbersActivity : AppCompatActivity() {

    lateinit var buttonBackNumber : ImageView
    lateinit var buttonUnion : Button
    lateinit var editTextNumberOne: EditText
    lateinit var editTextNumberTwo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_union_numbers)

        buttonBackNumber = findViewById(R.id.backImageViewAddNumbers)
        buttonUnion = findViewById(R.id.unionButton)

        buttonBackNumber.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonUnion.setOnClickListener {
            print("UNIENDO NUMEROS XD")
            //TODO obtener valores y hacer union find
        }



    }




}
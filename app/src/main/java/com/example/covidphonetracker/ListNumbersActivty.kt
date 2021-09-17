package com.example.covidphonetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListNumbersActivty : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_numbers_activty)

        val arrayAdapter:ArrayAdapter<*>

        var numeros = mutableListOf("72010260","77500213","2404319008","2","8","7","6","2","ejemplo","samuel","salado")

        val lvDatos = findViewById<ListView>(R.id.lvDatos)


        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,numeros)

        lvDatos.adapter = arrayAdapter
    }
}
package com.example.covidphonetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class ListNumbersActivty : AppCompatActivity() {


    var unionNumbersActivityObject : unionNumbersActivity = unionNumbersActivity()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_numbers_activty)

        //mostrar el array

        val arr : IntArray = unionNumbersActivityObject.unionFindArr

        var res : String = ""
        for (i in arr){
            res += " |" + arr[i]+ "|"
        }

        Log.d(" UNION ", res )


    }





}
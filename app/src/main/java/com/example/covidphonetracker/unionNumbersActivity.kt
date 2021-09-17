package com.example.covidphonetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast


class unionNumbersActivity : AppCompatActivity() {

    lateinit var buttonBackNumber : ImageView
    lateinit var buttonUnion : Button
    lateinit var editTextNumberOne: EditText
    lateinit var editTextNumberTwo: EditText
    lateinit var mapNumbers : MutableMap<String,Int>
    lateinit var mapNumberPhone : MutableMap<Int,String>
    lateinit var imageView: ImageView


    var unionFindObject : UnionFind = UnionFind(100)

    var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_union_numbers)

        buttonBackNumber = findViewById(R.id.backImageViewAddNumbers)
        buttonUnion = findViewById(R.id.unionButton)
        imageView = findViewById(R.id.imageView2)

        mapNumbers = mutableMapOf("0" to -1)
        mapNumberPhone = mutableMapOf(-1 to "0")

        buttonBackNumber.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonUnion.setOnClickListener {


            editTextNumberOne = findViewById(R.id.number1)
            editTextNumberTwo = findViewById(R.id.number2)

            unionNumbers(editTextNumberOne.text.toString(),editTextNumberTwo.text.toString())



        }

        imageView.setOnClickListener{

            val arr : IntArray = unionFindObject.roots

            var res : String = ""
            for (i in arr){
                res += " |" + arr[i]+ "|"
            }

            Log.d(" UNION ", res )

        }



    }


    fun unionNumbers(number1 : String , number2 : String){


        value++
        mapNumberPhone.set(value,number1)
        mapNumbers.set(number1,value)
        value++
        mapNumberPhone.set(value,number2)
        mapNumbers.set(number2,value)


        val n1  = mapNumbers.get(number2)
        val n2  = mapNumbers.get(number1)


        unionFindObject.union(Integer.parseInt(n1.toString()),Integer.parseInt(n2.toString()))

        Toast.makeText(baseContext , " Union Completada " , Toast.LENGTH_SHORT).show()


    }



    }





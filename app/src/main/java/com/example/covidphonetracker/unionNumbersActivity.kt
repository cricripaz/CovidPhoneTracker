package com.example.covidphonetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.ListView


class unionNumbersActivity : AppCompatActivity() {

    lateinit var buttonBackNumber : ImageView
    lateinit var buttonUnion : Button
    lateinit var buttonFind : Button
    lateinit var numeros: MutableList<String>
    lateinit var editTextNumberOne: EditText
    lateinit var editTextNumberTwo: EditText
    lateinit var numberToSearch: EditText
    lateinit var mapNumbers : MutableMap<String,Int>
    lateinit var mapNumberPhone : MutableMap<Int,String>

    var listaInfectados : MutableList<String> = mutableListOf()
    var listaIndexInfectados : MutableList<Int> = mutableListOf()





    var unionFindObject : UnionFind = UnionFind(100)



    var value = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_union_numbers)

        buttonBackNumber = findViewById(R.id.backImageViewAddNumbers)
        buttonUnion = findViewById(R.id.unionButton)
        buttonFind = findViewById(R.id.buttonFind)




        mapNumbers = mutableMapOf("0" to -1)
        mapNumberPhone = mutableMapOf(-1 to "0")



        //Creando List View






        buttonBackNumber.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonUnion.setOnClickListener {


            editTextNumberOne = findViewById(R.id.number1)
            editTextNumberTwo = findViewById(R.id.number2)

            unionNumbers(editTextNumberOne.text.toString(),editTextNumberTwo.text.toString())



        }

        buttonFind.setOnClickListener{

            numberToSearch = findViewById(R.id.editTextPhone)
            var codeNumber = mapNumbers.get(numberToSearch.text.toString())
            if(codeNumber != null) {
                var listOfInfectedIndex: MutableList<Int> = findPeopleWithCovid(codeNumber)
                var listOfInfected: MutableList<String> = mutableListOf()

                listOfInfectedIndex.forEach() {
                    listOfInfected.add(mapNumberPhone.get(it).toString())
                }

                val arrayAdapter: ArrayAdapter<*>


                val lvDatos = findViewById<ListView>(R.id.lvDatos)


                arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listOfInfected)

                lvDatos.adapter = arrayAdapter
            }
        }
    }


    fun unionNumbers(number1 : String , number2 : String){

        if(mapNumbers.get(number1) == null){
            value++
            mapNumberPhone.set(value,number1)
            mapNumbers.set(number1,value)
        }

        if(mapNumbers.get(number2) == null){
            value++
            mapNumberPhone.set(value,number2)
            mapNumbers.set(number2,value)
        }


        val n1  = mapNumbers.get(number2)
        val n2  = mapNumbers.get(number1)


        unionFindObject.union(Integer.parseInt(n1.toString()),Integer.parseInt(n2.toString()))

        Toast.makeText(baseContext , " Union Completada " , Toast.LENGTH_SHORT).show()


    }


    fun findPeopleWithCovid(numberPhone: Int?):MutableList<Int>{
        var listOfInfected: MutableList<Int> = mutableListOf()
        var parentOfNumber = unionFindObject.find(numberPhone)
        var number = numberPhone
        for(i in 0..unionFindObject.roots.size-1) {
            var index = i
            var parent = unionFindObject.find(index)
            while (index != parent) {
                index = parent
                parent = unionFindObject.find(index)
                if (parent == numberPhone) {
                    listOfInfected.add(i)
                    break
                }
            }
        }
        while(number != parentOfNumber){
            listOfInfected.add(parentOfNumber)
            number = parentOfNumber
            parentOfNumber = unionFindObject.find(number)
        }
//
//            val valueOfNumber   = mapNumbers.get(numberPhone)
//            val infectado : Int = unionFindObject.find(valueOfNumber)
//
//
//        for (i in unionFindObject.roots){
//
//            if (infectado == unionFindObject.roots[i]){
//                listaIndexInfectados.add(i)
//            }
//
//        }

        //{indices }

        //for each add 5 -> "5232", 6 -> "fsfsf"










        return listOfInfected

    }



    }





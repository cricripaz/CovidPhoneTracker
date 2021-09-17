package com.example.covidphonetracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter


class NumeroAdapter (private val mContext : Context , private val listOfNumbers : List<Numero>) : ArrayAdapter<Numero>
    (mContext,0,listOfNumbers){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_numero, parent, false)


        val numeros = listOfNumbers[position]



        return layout

    }

}
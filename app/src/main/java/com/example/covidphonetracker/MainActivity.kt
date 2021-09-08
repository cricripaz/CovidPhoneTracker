package com.example.covidphonetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.covidphonetracker.databinding.ActivityMainBinding
import com.example.covidphonetracker.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        auth = Firebase.auth



        binding.card00.setOnClickListener {
            val intent = Intent(this , addNumbersActivity::class.java)
            startActivity(intent)
        }


        binding.card01.setOnClickListener {
            val intent = Intent(this , ListNumbersActivty::class.java)
            startActivity(intent)
        }

    }




}
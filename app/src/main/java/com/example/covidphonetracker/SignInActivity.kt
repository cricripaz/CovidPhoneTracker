
package com.example.covidphonetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.covidphonetracker.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)



        setContentView(binding.root)

        mAuth = Firebase.auth

        binding.signInAppCompatButton.setOnClickListener{
            val mEmail  = binding.emailEditText.text.toString()
            val mPassword = binding.passwordEditText.text.toString()

            print(mEmail)
            print(mPassword)

            when {
                mEmail.isEmpty() || mPassword.isEmpty() -> {
                    Toast.makeText(baseContext , " Correo o Contrasenia Incorrecta" , Toast.LENGTH_SHORT).show()
                }else -> {
                    signIn(mEmail,mPassword)
                }
            }


        }
    }

    private fun signIn(email : String , password : String){

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "signInWithEmail:success")
                    reload()
                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun reload(){
        val intent = Intent(this,MainActivity::class.java)
        this.startActivity(intent)
    }
}
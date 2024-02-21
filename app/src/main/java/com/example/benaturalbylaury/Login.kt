package com.example.benaturalbylaury

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.benaturalbylaury.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        // Création du bouton pour aller à la page de création de compte
        val buttonClick = findViewById<TextView>(R.id.buSignUp)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


        binding.loginButton.setOnClickListener{
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty() )
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Vous \\êtes conn\\éct\\é ", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Home ::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        // val intentActuel = Intent(this, )
                    }
                }
            else
                Toast.makeText(this, "Les champs sont vides !", Toast.LENGTH_SHORT).show()
        }
    }
}
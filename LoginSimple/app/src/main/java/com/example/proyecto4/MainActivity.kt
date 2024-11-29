package com.example.proyecto4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Toast
import com.example.proyecto4.MainActivity
import com.example.proyecto4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //1. Declaramos la variable Binding
    private lateinit var binding: ActivityMainBinding
    private val usernamePredefined = "sebastian"
    private val passwordPredefined = "sebas2503"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //1. Declaramos la variable Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //3. Configuramos el Boton para iniciar sesion
        binding.btnLogin.setOnClickListener{
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Porfa llena todos los campos", Toast.LENGTH_LONG).show()

            } else{
                val intent = Intent(this, Divisa::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }

            if (username == usernamePredefined && password == passwordPredefined){
                Toast.makeText(this, "Sesion Iniciada",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Divisa::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Error en credenciales", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
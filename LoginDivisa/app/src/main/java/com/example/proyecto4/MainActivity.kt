package com.example.proyecto4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding for the layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OnClickListener for the login button
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Check hardcoded credentials
            if (username == "usuario" && password == "contrasena") {
                // Login successful, navigate to Divisa activity
                val intent = Intent(this, Divisa::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                // Show error message
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

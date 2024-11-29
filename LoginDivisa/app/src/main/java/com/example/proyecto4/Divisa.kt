package com.example.proyecto4

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto4.databinding.DivisaBinding

class Divisa : AppCompatActivity() {

    // Binding for the layout
    private lateinit var binding: DivisaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DivisaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Currency options
        val currencies = arrayOf("USD", "EUR", "MXN")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        // Handle conversion
        binding.convertButton.setOnClickListener {
            val amount = binding.monto.text.toString().toDoubleOrNull()
            val targetCurrency = binding.spinner.selectedItem.toString()

            if (amount != null && targetCurrency.isNotEmpty()) {
                val conversionRate = when (targetCurrency) {
                    "USD" -> 0.27 // Conversion rate to USD
                    "EUR" -> 0.25 // Conversion rate to EUR
                    "MXN" -> 4.70 // Conversion rate to MXN
                    else -> 1.0
                }
                val result = amount * conversionRate
                binding.resultado.setText("%.2f".format(result))
            } else {
                binding.resultado.setText("Error")
            }
        }

        // Display welcome message with the username passed from MainActivity
        val username = intent.getStringExtra("username")
        binding.tvWelcome.text = "Bienvenido $username"

        // Logout button
        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

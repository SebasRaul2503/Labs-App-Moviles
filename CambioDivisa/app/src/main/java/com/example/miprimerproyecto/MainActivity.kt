package com.example.miprimerproyecto

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar View Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el Spinner para las divisas
        val currencies = arrayOf("USD", "EUR", "MXN")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        // conversión de Soles
        binding.convertButton.setOnClickListener {
            val amount = binding.monto.text.toString().toDoubleOrNull()
            val targetCurrency = binding.spinner.selectedItem.toString()

            if (amount != null && targetCurrency.isNotEmpty()) {
                // Tasas de conversión desde Soles (PEN)
                val conversionRate = when (targetCurrency) {
                    "USD" -> 0.27 // 1 Sol = 0.27 Dólares
                    "EUR" -> 0.25 // 1 Sol = 0.25 Euros
                    "MXN" -> 4.70 // 1 Sol = 4.70 Pesos Mexicanos
                    else -> 1.0 // Moneda por defecto (Soles)
                }
                val result = amount * conversionRate
                // Mostrar solo el número, sin texto adicional
                binding.resultado.setText("%.2f".format(result))
            } else {
                binding.resultado.setText("Error") // En caso de valores inválidos
            }
        }
    }
}


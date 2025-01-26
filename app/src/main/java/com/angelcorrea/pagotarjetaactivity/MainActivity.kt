package com.angelcorrea.pagotarjetaactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val numeroTarjetaEditText = findViewById<EditText>(R.id.editTextText) 
        val fechaExpiracionEditText = findViewById<EditText>(R.id.editTextDate)
        val cvvEditText = findViewById<EditText>(R.id.editTextText2)
        val pagarButton = findViewById<Button>(R.id.button)

        pagarButton.setOnClickListener {
            val numeroTarjeta = numeroTarjetaEditText.text.toString()
            val fechaExpiracion = fechaExpiracionEditText.text.toString()
            val cvv = cvvEditText.text.toString()

            if (numeroTarjeta.isEmpty() || fechaExpiracion.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                val mensaje = """
                    Número de Tarjeta: $numeroTarjeta
                    Fecha de Expiración: $fechaExpiracion
                    CVV: $cvv
                """.trimIndent()
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }

    }
}
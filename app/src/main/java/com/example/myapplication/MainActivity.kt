package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var pais1EditText: EditText
    private lateinit var pais2EditText: EditText
    private lateinit var pais3EditText: EditText
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pais1EditText = findViewById(R.id.editTextPais1)
        pais2EditText = findViewById(R.id.editTextPais2)
        pais3EditText = findViewById(R.id.editTextPais3)
        button = findViewById(R.id.buttonNext)

        button.setOnClickListener {
            val pais1 = pais1EditText.text.toString()
            val pais2 = pais2EditText.text.toString()
            val pais3 = pais3EditText.text.toString()

            if (pais1.isNotEmpty() && pais2.isNotEmpty() && pais3.isNotEmpty()) {
                val intent = Intent(this, SeleccionarPaisActivity::class.java)
                intent.putExtra("pais1", pais1)
                intent.putExtra("pais2", pais2)
                intent.putExtra("pais3", pais3)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Debes ingresar los tres países", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


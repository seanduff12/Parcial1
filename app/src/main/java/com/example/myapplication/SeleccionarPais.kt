package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SelectCountryActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var listView: ListView

    // Lista de deportistas por país
    private val colombiaDeportistas = listOf(
        Deportista("James Rodríguez", "Fútbol", false),
        Deportista("Nairo Quintana", "Ciclismo", true),
        Deportista("Mariana Pajón", "BMX", true),
        Deportista("Radamel Falcao", "Fútbol", true),
        Deportista("Caterine Ibargüen", "Atletismo", false),
        Deportista("Egan Bernal", "Ciclismo", true),
        Deportista("Juan Pablo Montoya", "Automovilismo", false),
        Deportista("Carlos Valderrama", "Fútbol", false),
        Deportista("Iván Córdoba", "Fútbol", false),
        Deportista("Oscar Figueroa", "Halterofilia", false)
    )

    private val argentinaDeportistas = listOf(
        Deportista("Lionel Messi", "Fútbol", true),
        Deportista("Manu Ginóbili", "Baloncesto", false),
        Deportista("Gabriela Sabatini", "Tenis", false),
        Deportista("Diego Maradona", "Fútbol", false),
        Deportista("Juan Martín del Potro", "Tenis", false),
        Deportista("Carlos Tevez", "Fútbol", false),
        Deportista("Sergio Agüero", "Fútbol", false),
        Deportista("Paula Pareto", "Judo", true),
        Deportista("Luciana Aymar", "Hockey", false),
        Deportista("Javier Mascherano", "Fútbol", false)
    )

    private val uruguayDeportistas = listOf(
        Deportista("Luis Suárez", "Fútbol", true),
        Deportista("Diego Forlán", "Fútbol", false),
        Deportista("Edinson Cavani", "Fútbol", true),
        Deportista("Enzo Francescoli", "Fútbol", false),
        Deportista("Pablo Cuevas", "Tenis", true),
        Deportista("Antonio Pacheco", "Fútbol", false),
        Deportista("Obdulio Varela", "Fútbol", false),
        Deportista("Álvaro Recoba", "Fútbol", false),
        Deportista("Diego Lugano", "Fútbol", false),
        Deportista("Sebastián Abreu", "Fútbol", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecc_pais)

        spinner = findViewById(R.id.spinner)
        listView = findViewById(R.id.listView)

        // Obtener los países de la actividad anterior
        val country1 = intent.getStringExtra("country1")
        val country2 = intent.getStringExtra("country2")
        val country3 = intent.getStringExtra("country3")
        val countries = listOf(country1, country2, country3)

        // Llenar el spinner con los países
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        spinner.adapter = adapter

        // Configurar el evento de selección del spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCountry = countries[position]
                val Deportistas = when (selectedCountry) {
                    country1 -> colombiaDeportistas
                    country2 -> argentinaDeportistas
                    country3 -> uruguayDeportistas
                    else -> emptyList()
                }

                val names = Deportistas.map { it.name }

                // Actualizar el ListView con los nombres de los deportistas
                val listAdapter = ArrayAdapter(this@SelectCountryActivity, android.R.layout.simple_list_item_1, names)
                listView.adapter = listAdapter

                // Configurar evento de selección de la lista
                listView.setOnItemClickListener { _, _, i, _ ->
                    val selectedDeportista = Deportistas[i]
                    val intent = Intent(this@SelectCountryActivity, AthleteDetailActivity::class.java)
                    intent.putExtra("name", selectedDeportista.name)
                    intent.putExtra("sport", selectedDeportista.sport)
                    intent.putExtra("active", selectedDeportista.isActive)
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se necesita implementación
            }
        }
    }
}

package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AthleteDetailActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var sportTextView: TextView
    private lateinit var activeTextView: TextView
    private lateinit var athleteImageView: ImageView
    private lateinit var activityStatusImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_deportista)


        nameTextView = findViewById(R.id.nameTextView)
        sportTextView = findViewById(R.id.sportTextView)
        activeTextView = findViewById(R.id.activeStatusTextView)
        athleteImageView = findViewById(R.id.athleteImageView)
        activityStatusImageView = findViewById(R.id.activityStatusImageView)


        val name = intent.getStringExtra("name")
        val sport = intent.getStringExtra("sport")
        val isActive = intent.getBooleanExtra("active", false)


        nameTextView.text = name
        sportTextView.text = "Deporte: $sport"
        activeTextView.text = if (isActive) "En actividad" else "Retirado"


        if (isActive) {
            activityStatusImageView.setImageResource(R.drawable.active_icon)
        } else {
            activityStatusImageView.setImageResource(R.drawable.retired_icon)
        }
    }
}


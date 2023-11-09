package com.example.claselayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        servicio()
        camara()
    }
    fun servicio (){
        val bot = findViewById<Button>(R.id.btn_gps)

        bot.setOnClickListener(){

            val saltar: Intent = Intent(this, ServicioGPS::class.java)
            startActivity(saltar)
        }
    }
    fun camara() {
        val bot = findViewById<Button>(R.id.btn_camara)

        bot.setOnClickListener() {

            val saltar: Intent = Intent(this, Camara::class.java)
            startActivity(saltar)
            }
        }
}








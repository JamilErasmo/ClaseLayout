package com.example.claselayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi


class Camara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)


            val btnCamara = findViewById<Button>(R.id.btn_camara)

            //Evento al presionar el botón
            btnCamara.setOnClickListener {
                startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            }
        }

        //Evento que procesa el resultado de la cámara y envía la vista previa de la foto al ImageView
        private val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    val imageBitmap = intent?.extras?.get("data") as Bitmap
                    val imageView = findViewById<ImageView>(R.id.imageView)
                    imageView.setImageBitmap(imageBitmap)
                }
            }
}

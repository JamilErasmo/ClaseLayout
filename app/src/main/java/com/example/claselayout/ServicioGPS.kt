package com.example.claselayout
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.widget.Toast


class ServicioGPS : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var btn_Data: Button
    lateinit var btn_home: Button
    lateinit var Inf_gps: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        btn_Data = findViewById(R.id.btn_Data)
        btn_home = findViewById(R.id.btn_home)
        Inf_gps = findViewById(R.id.Inf_gps)

        btn_Data.setOnClickListener {
            var msgLatLong = "Ubicacion"
            Inf_gps.text = msgLatLong
            findLocation()
        }

        btn_home.setOnClickListener {
            var intentRegresar: Intent = Intent(this, MainActivity::class.java)
            startActivity(intentRegresar)
        }
    }
    fun findLocation(){
        val task = fusedLocationProviderClient.lastLocation
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }

        task.addOnSuccessListener {
            if (it!=null){
                Toast.makeText(applicationContext, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
                Inf_gps.setText("${it.latitude} ${it.longitude} - ${it.altitude}")
            }
        }
    }

}
package com.example.mysecurity

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.CustomCap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var builder: AlertDialog.Builder

    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        createFragment()
        builder = AlertDialog.Builder(this)
    }

    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //createMarker()
        createPolylines()
        enableLocation()
    }
    private fun createPolylines(){
        val polylineOptions = PolylineOptions()
            .add(LatLng(40.419173113350965,-3.705976009368897))
            .add(LatLng( 40.4150807746539, -3.706072568893432))
            .add(LatLng( 40.41713105928677, -3.7037122249603267))
            .add(LatLng( 40.419173113350965, -3.7048280239105225))
            .add(LatLng(40.419173113350965,-3.705976009368897))
            .width(15f)
        val polyline = map.addPolyline(polylineOptions)
        polyline.isClickable = true
        polyline.startCap = RoundCap()
        polyline.endCap = RoundCap()

        map.setOnPolygonClickListener {
            builder.setTitle("PROBLEMITAS")
                .setMessage("Escasa luz")
                .setCancelable(true)
                .setPositiveButton("ACEPTAR"){dialogInterface, it->
                    dialogInterface.cancel()
                }
                .show()
        }

        val poligonoOption = PolygonOptions().add(LatLng(40.419173113350965,-3.705976009368897))
            .add(LatLng( 40.4150807746539, -3.706072568893432))
            .add(LatLng( 40.41517062907432, -3.7012016773223873))
            .add(LatLng( 40.41713105928677, -3.7037122249603267))
            .add(LatLng( 40.41926296230622,  -3.701287508010864))
            .add(LatLng( 40.419173113350965, -3.7048280239105225))
            .add(LatLng(40.419173113350965,-3.705976009368897))
            .fillColor(ContextCompat.getColor(this, R.color.yellow))
            //.color(ContextCompat.getColor(this, R.color.purple_500))

        //polyline.endCap = CustomCap()
        val poligono = map.addPolygon(poligonoOption)
        poligono.isClickable = true
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng( 40.4150807746539, -3.706072568893432), 18f),
            4000,
            null
        )
        map.setOnPolygonClickListener {
            builder.setTitle("PROBLEMITAS")
                .setMessage("Robo bolso")
                .setCancelable(true)
                .setPositiveButton("ACEPTAR"){dialogInterface, it->
                    dialogInterface.cancel()
                }
                .show()
        }
        val circleOption = CircleOptions()
            .center(LatLng(40.419173113350965,-3.705976009368897))
            .radius(100.0)
            .fillColor(ContextCompat.getColor(this, R.color.red))
        val circle =map.addCircle(circleOption)
        circle.isClickable = true

        map.setOnCircleClickListener {
            builder.setTitle("PROBLEMITAS")
                .setMessage("Zona peligrosa")
                .setCancelable(true)
                .setPositiveButton("ACEPTAR"){dialogInterface, it->
                    dialogInterface.cancel()
                }
                .show()
        }
    }
    private fun createMarker(){
        var coordenadas = LatLng(40.547037, -3.691659)
        var marker: MarkerOptions = MarkerOptions().position(coordenadas).title("EPS UAM")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordenadas, 18f),
            4000,
            null
        )
    }
    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    )==PackageManager.PERMISSION_GRANTED

    private fun enableLocation(){
        if (!::map.isInitialized) return
        if(isLocationPermissionGranted()){
            map.isMyLocationEnabled = true
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
                Toast.makeText(this, "los persisos fueron rechazados, ve a ajustes", Toast.LENGTH_SHORT)
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),REQUEST_CODE_LOCATION)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE_LOCATION-> if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(this, "Ve a ajustes  a aceptar los permisos", Toast.LENGTH_SHORT)
            }
            else->{}
        }
    }

}
package com.nicos.sampleforegroundservice.service

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.nicos.sampleforegroundservice.R

class LocationService : Service(), LocationListener {


    override fun onCreate() {
        notificationService()
        super.onCreate()
    }

    private fun notificationService() {
        Notification.Builder(this, "Location Channel").apply {
            setContentTitle("Location Service")
            setOngoing(true)
            setContentText("Running Service to find you location")
            setSmallIcon(R.drawable.ic_notifcation_icon)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            NotificationChannel("Location Channel", "Location", importance).apply {
                description = "Running Service to find you location"
                with((this@LocationService.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)) {
                    createNotificationChannel(this@apply)
                }
            }
            this@LocationService.startForeground(1, this.build())
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkForGrandeLocationPermission()) {
                locationManager.requestLocationUpdates(
                    LocationManager.FUSED_PROVIDER,
                    10000,
                    0f,
                    this@LocationService
                )
            } else {
                val criteria = Criteria().apply {
                    accuracy = Criteria.ACCURACY_COARSE
                    powerRequirement =
                        Criteria.POWER_LOW
                }
                val provider = locationManager.getBestProvider(
                    criteria,
                    false
                )
                if (provider != null) {
                    locationManager.requestLocationUpdates(
                        provider,
                        10000,
                        0f,
                        this@LocationService
                    )
                }
            }
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onLocationChanged(location: Location) {
        Toast.makeText(this, "${location.latitude} and ${location.longitude}", Toast.LENGTH_LONG)
            .show()
    }

    private fun checkForGrandeLocationPermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}
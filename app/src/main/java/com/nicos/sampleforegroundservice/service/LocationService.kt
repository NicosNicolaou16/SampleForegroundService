package com.nicos.sampleforegroundservice.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.nicos.sampleforegroundservice.R

class LocationService : Service() {


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

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
package com.nicos.sampleforegroundservice.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.nicos.sampleforegroundservice.RESTART_SERVICE
import com.nicos.sampleforegroundservice.service.LocationService
import com.nicos.sampleforegroundservice.utils.secure_share_preferences.SecureSharePreferences

/**
 * This broadcast receiver is using to start the service after reboot the mobile device if user
 * has enabled the service (Optional)
 * */
class RestartServiceBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val secureSharePreferences = context?.let { SecureSharePreferences(context = it) }

        if (intent?.action != null && intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val shouldStartTheService = secureSharePreferences?.getBooleanValue(RESTART_SERVICE)
            if (shouldStartTheService == true) {
                context.startService(Intent(context, LocationService::class.java))
            }
        }
    }
}
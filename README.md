# Sample Foreground Service
This sample project shows the setup for the foreground service. The service in this sample project is a foreground service to request location.
The permission for <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION" /> is depend of the foreground service type.

## Similar project with (Dart Language)

https://github.com/NicosNicolaou16/SampleForegroundServiceFlutter <br />

# Manifest Setup
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

    <!--Location Permissions-->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />

    <!--Foreground Service Permissions-->
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION" />

    <!--Restart Service After Reboot the Mobile Device-->
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

    <application>
        <!--other code here-->

        <!--Service-->
        <service
            android:name=".service.LocationService"
            android:enabled="true"
            android:exported="false"
            android:foregroundServiceType="location" />

        <!--Broadcast Receiver (Optional)-->
        <receiver
            android:name=".broadcast_receiver.RestartServiceBroadcastReceiver"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED" />
            </intent-filter>
        </receiver>
        
        <!--other code here-->
    </application>
</manifest>
```

# References
https://developer.android.com/about/versions/14/changes/fgs-types-required <br />
https://stackoverflow.com/questions/14385231/android-broadcastreceiver-auto-run-service-after-reboot-of-device <br />

## Check my article 
https://medium.com/@nicosnicolaou/foreground-service-in-android-9ff18be69ef6 <br />

Target SDK version: 34 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.0.0 <br />
Gradle version: 8.5.2 <br />
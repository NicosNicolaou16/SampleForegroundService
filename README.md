# Sample Foreground Service
This sample project shows the setup for the foreground service. The service in this sample project is a foreground service to request location.
The permission for <uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION" /> is depend of the foreground service type.

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

    <application>
        <!--other code here-->

        <!--Service-->
        <service
            android:name=".service.LocationService"
            android:enabled="true"
            android:exported="false"
            android:foregroundServiceType="location" />

        <!--other code here-->
    </application>
</manifest>
```

# References
https://developer.android.com/about/versions/14/changes/fgs-types-required <br />
https://stackoverflow.com/questions/14385231/android-broadcastreceiver-auto-run-service-after-reboot-of-device <br />

## Check my article 


Target SDK version: 34 <br />
Minimum SDK version: 27 <br />
Kotlin version: 1.9.20 <br />
Gradle version: 8.2.0 <br />